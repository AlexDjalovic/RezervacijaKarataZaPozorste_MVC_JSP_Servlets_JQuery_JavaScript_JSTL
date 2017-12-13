<%-- 
    Document   : pozoriste
    Created on : Nov 22, 2017, 4:56:17 PM
    Author     : Aleksandar Djalovic
--%>
<sql:setDataSource  var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/teatar" user="root" password=""/> 
<sql:query var="rs" scope="request" dataSource="${con}" >
    SELECT idPozorista, nazivPozorista,adresa  FROM pozoriste;
</sql:query>


    <h1> Forma za unos i pregled podataka o pozoristima</h1>
    
    
    <form action="insertPozoristeServlet" method="POST" class="pozoristeForm">
        <table  id="tabelicapozoriste">
            <tr>
                <td> naziv pozorista:</td>
                <td><input type="text" name="tfnazivPozorista" value="" /></td>
            </tr>
            <tr>
                <td>adresa:</td>
                <td><input type="text" name="tfadresaPozorista" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="UPISI" /></td>
            </tr>
        </table>
    </form>
    
    
    <form class="pozoristeForm">
        <table class="tabelicapozoriste">
            <tr>
                <th>idPozorista</th>
                <th>naziv pozorista</th>
                <th>adresa:</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="deo" items="${rs.rows}">
                <tr>
                    <td>${deo.idPozorista}</td>
                    <td>${deo.nazivPozorista}</td>
                    <td>${deo.adresa}</td>
                    <td><a href="EditFormaPozorista?id=${deo.idPozorista}">Promeni</a></td>
                    <td><a href="DeleteFormaPozorista?id=${deo.idPozorista}">Obrisi</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <form action="povratakServlet">
        <input type="submit" value="VRATI SE NA OSNOVNI ADMIN NIVO" />
    </form>
