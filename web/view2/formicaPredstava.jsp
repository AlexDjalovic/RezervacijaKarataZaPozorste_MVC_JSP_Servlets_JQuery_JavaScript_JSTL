<%-- 
    Document   : formicaPredstava
    Created on : Nov 24, 2017, 4:20:04 PM
    Author     : Aleksandar Djalovic
--%>
<sql:setDataSource  var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/teatar" user="root" password=""/>
  <sql:query var="podatak" dataSource="${con}">
        SELECT DISTINCT idPozorista, nazivPozorista,adresa  FROM pozoriste;
    </sql:query>
<h1>forma da promenite podatke o predstavi</h1>    <br><br>
        
        <form action="updatePredstava" method="POST">
             <input type="hidden" name="id" value="${predstava.idPredstave}"/>
              <table>
                <tr>
                <td>naziv predstave:</td>
                <td><input type="text" name="tfnazPred" value="${predstava.nazivPredstave}" /></td>
                </tr>
                  <tr>
                <td>reziser:</td>
                <td><input type="text" name="tfrez" value="${predstava.reziser}" /></td>
                </tr>
                  <tr>
                <td>glumci:</td>
                <td><input type="text" name="tfglum" value="${predstava.glumci}" /></td>
                </tr>
                <tr>
                    <td>pozoriste:</td>
                    <td>  
                        <select name="combo1">
                            <c:forEach var="pp" items="${podatak.rows}">
                                <option>${pp.nazivPozorista}</option>
                                <c:if test="${predstava.idPozorista==pp.idPozorista}">
                                    <option selected >${pp.nazivPozorista}</option>
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
  