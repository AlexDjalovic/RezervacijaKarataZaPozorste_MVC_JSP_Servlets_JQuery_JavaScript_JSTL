<%-- 
    Document   : formicaTermin
    Created on : Nov 25, 2017, 4:18:30 PM
    Author     : Aleksandar Djalovic
--%>
<sql:setDataSource  var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/teatar" user="root" password=""/>
<sql:query var="podatak" dataSource="${con}">
        SELECT DISTINCT *  FROM predstava;
    </sql:query>

       <h1>forma da promenite podatke o Terminu predstave</h1>    <br><br>
 
 
        <form action="updateTermin" method="POST">
             <input type="hidden" name="id" value="${termin.idTermina}"/>
              <table>
                <tr>
                <td>Datum:</td>
                <td><input type="text" name="tfdatum" value="${termin.datum}" /></td>
                </tr>
                  <tr>
                <td>ukupan broj karata:</td>
                <td><input type="text" name="tfubk" value="${termin.ukupanBrojKarata}" /></td>
                </tr>
                
                <tr>
                    <td>pozoriste:</td>
                    <td>  
                        <select name="combo1">
                            <c:forEach var="pp" items="${podatak.rows}">
                                <option>${pp.nazivPredstave}</option>
                                <c:if test="${termin.idPredstave==pp.idPredstave}">
                                    <option selected >${pp.nazivPredstave}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </td>
                </tr>
            <tr>
                    <td colspan="2"><input type="submit" value="promeni" /></td>
                </tr>
              </table>            
        </form>
  