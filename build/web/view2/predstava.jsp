
<%-- 
    Document   : predstava
    Created on : Nov 22, 2017, 4:56:31 PM
    Author     : Aleksandar Djalovic
--%>
<sql:setDataSource  var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/teatar" user="root" password=""/>
<%-- OVO JE ZA POPUNJAVANJE TABELE ZA PREDSTAVE KOJA TREBA DA SE AZURIRA--%>
<sql:query var="rs" scope="request" dataSource="${con}" >
    SELECT idPredstave,nazivPredstave,reziser,glumci, idPozorista FROM predstava;
</sql:query>
    
    <%-- OVO JE ZA POPUNJAVANJE PADAJUCEG MENIJA--%>
    <sql:query var="podatak" dataSource="${con}">
        SELECT idPozorista, nazivPozorista,adresa  FROM pozoriste;
    </sql:query>
        
        <%-- POCINJE FORMA--%>
        <h1>Forma za unos i pregled podataka o pozoristima</h1>
        <form action="insertPredstavaServlet" method="POST" class="pozoristeForm">
        <table  id="tabelicapozoriste">
            <tr>
                <td> naziv predstave:</td>
                <td><input type="text" name="tfnazivPredstave" value="" /></td>
            </tr>
            <tr>
                <td>reziser:</td>
                <td><input type="text" name="tfreziser" value="" /></td>
            </tr>
             <tr>
                <td>glumci:</td>
                <td><input type="text" name="tfglumci" value="" /></td>
            </tr>
            <tr>
                <td>pozoriste</td>
                <td>
            <select name="combo1">
                <c:forEach var="pp" items="${podatak.rows}">
                    <option>${pp.nazivPozorista}</option>
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
                    <th>idPredstave</th>
                    <th>naziv predstave</th>
                    <th>reziser</th>
                    <th>glumci</th>
                    <th>pozoriste</th>
                    <th> </th>
                    <th> </th>
                </tr>

                <c:forEach var="deo" items="${rs.rows}">
                    <tr>
                        <td style="text-align: center">${deo.idPredstave}</td>
                        <td>${deo.nazivPredstave}</td>
                        <td>${deo.reziser}</td>
                        <td>${deo.glumci}</td>
                        <c:forEach var="xx" items="${podatak.rows}">
                            <c:if test="${deo.idPozorista == xx.idPozorista}">
                                <td>${xx.nazivPozorista}</td>
                            </c:if>

                        </c:forEach>

                        <td><a href="EditFormaPredstava?id=${deo.idPredstave}">Promeni</a></td>
                        <td><a href="DeleteFormaPredstava?id=${deo.idPredstave}">Obrisi</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <br><br>
          <form action="povratakServlet">
        <input type="submit" value="<<VRATI SE NA OSNOVNI ADMIN NIVO" />
    </form>