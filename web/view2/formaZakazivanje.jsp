<%-- 
    Document   : formaZakazivanje
    Created on : Nov 29, 2017, 7:34:33 PM
    Author     : Aleksandar Djalovic
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%--
<sql:setDataSource  var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/teatar" user="root" password=""/> 
<sql:query var="rs" dataSource="${con}" >
    SELECT  t.ukupanBrojKarata,p.nazivPredstave,p.reziser,p.glumci,poz.nazivPozorista
FROM termin AS t INNER JOIN predstava AS p
ON t.idPredstave=p.idPredstave
INNER JOIN pozoriste AS poz
ON p.idPozorista=poz.idPozorista
WHERE t.Datum="2017-11-26"
</sql:query>
--%>
        <h1>forma za zakazivanje</h1>
          
<table>
            <tr>
                <th>brojKarata</th>
                <th>predstava</th>
                <th>rezija</th>
                <th>glumci</th>
                <th>pozoriste</th>              
            </tr>
             <c:forEach var="xx" items="${al}">
            <tr>
               
                <td>${xx.ukupanBrojKarata}</td>
                 <td>${xx.nazivPredstave}</td>
                 <td>${xx.reziser}</td>
                 <td>${xx.glumci}</td>
                 <td>${xx.nazivPozorista}</td>
                 
            </tr>
            </c:forEach>
        </table>
  
 