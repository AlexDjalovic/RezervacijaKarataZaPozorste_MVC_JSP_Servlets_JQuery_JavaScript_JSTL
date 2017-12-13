<%-- 
    Document   : termin
    Created on : Nov 22, 2017, 4:56:44 PM
    Author     : Aleksandar Djalovic
--%>
<sql:setDataSource  var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/teatar" user="root" password=""/>
<sql:query var="podatak" dataSource="${con}">
    SELECT *FROM predstava
</sql:query>
    
    <sql:query var="rs" scope="request" dataSource="${con}" >
    SELECT * FROM termin;
</sql:query>
     <%-- POCINJE FORMA--%>
        <h1>Forma za unos i pregled podataka o pozoristima</h1>
        <h3>${poruka}</h3>
        <form action="insertterminServlet" method="POST" class="pozoristeForm">
        <table  id="tabelicapozoriste">
            <tr>
                <td> Datum:</td>
               <%--   <td><input type="date" name="tfdatum" value="yyyy-mm-dd" /></td>--%>
               <%-- date input u chromu i u edgeu nije isti i zato ne znam kako da pokupim podatke i da ih obradim u servletu--%>
               <td> 
                   <select name="dan">
                   <c:forEach var="i"  begin="1" end="31" step="1">
                       <option>${i}</option>
                   </c:forEach>
                       </select>
                   <select name="mesec">
                   <c:forEach var="i"  begin="1" end="12" step="1">
                       <option>${i}</option>
                   </c:forEach>
                       </select>
                   <select name="god">
                   <c:forEach var="i"  begin="2017" end="2020" step="1">
                       <option>${i}</option>
                   </c:forEach>
                       </select>
               </td>
            </tr>
            <tr>
                <td>ukupan broj karata:</td>
                <td><input type="text" name="tfkarte" value="" /></td>
            </tr>
            
            <tr>
                <td>predstava:</td>
                <td>
            <select name="combo1">
                <c:forEach var="pp" items="${podatak.rows}">
                    <option>${pp.nazivPredstave}</option>
                </c:forEach>
               
            </select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="UPISI" /></td>
            </tr>
        </table>
    </form>
   
   <form class="pozoristeForm">
            <table class="tabelicapozoriste" >
                <tr>
                    <th>idTermina</th>
                    <th>datum</th>
                    <th>broj karata</th>
                    <th>naziv predstave</th>
                    <th> </th>
                    <th> </th>
                </tr>

                <c:forEach var="deo" items="${rs.rows}">
                    <tr>
                        <td style="text-align: center">${deo.idTermina}</td>
                        <td>${deo.Datum}</td>                      
                        <td>${deo.ukupanBrojKarata}</td>
                        <c:forEach var="xx" items="${podatak.rows}">
                            <c:if test="${deo.idPredstave == xx.idPredstave}">
                                <td>${xx.nazivPredstave}</td>
                            </c:if>

                        </c:forEach>

                        <td><a href="EditFormaTermin?id=${deo.idTermina}">Promeni</a></td>
                        <td><a href="DeleteFormaTermin?id=${deo.idTermina}">Obrisi</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <br><br>
          <form action="povratakServlet">
        <input type="submit" value="<<VRATI SE NA OSNOVNI ADMIN NIVO" />
    </form>