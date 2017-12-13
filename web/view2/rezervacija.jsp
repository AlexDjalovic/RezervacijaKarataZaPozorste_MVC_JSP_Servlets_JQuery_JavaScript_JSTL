<%-- 
    Document   : rezervacija
    Created on : Nov 22, 2017, 4:56:03 PM
    Author     : Aleksandar Djalovic
--%>


<%@page import="beans.Korisnik"%>
<%@page import="util.UpitiBaza"%>
<h1>rezervacija</h1>


<%
    //moram da pokupim user koji sam poslao sa login servleta i da nadjem idKorisnika
    String username = (String) request.getAttribute("user");
    int idKorisnika = 0;
    for (Korisnik k : UpitiBaza.vratiKorisnike()) {
        if (k.getUsername().equalsIgnoreCase(username)) {
            idKorisnika = k.getIdKorisnika();
        }
    }
    //kada sam pronasao id konkretnog korisnika moram ga staviti  kao atribut kojem ce se pristupati u jsp
    HttpSession  sesija =request.getSession();
    //request.setAttribute("id", idKorisnika);
    sesija.setAttribute("id", idKorisnika);
    //moram prvo da nadjem naziv predstave pa onda da se prikazu termini slobodni i broj karata
%>

Dobrodosli,  <%=username%><br><br>


    <%--
<input type="text" name="Idkorisnika" value="${id}" />
    
    --%>
     <div id="adminyglavnidiv">
         <form action="ControlRezervacije" method="post">
         
         <div class="adminydugmici"><input type="submit" value=" PRETRAGA PO DATUMIMA" name="DATUMI" id="Datumi"/></div>
         
            </form>
         <form action="pretragaPoNazivima">
             <div class="adminydugmici"><input type="submit" value=" PRETRAGA PO NAZIVIMA PREDSTAVA" name="PREDSTAVE" id="predstave"/></div>
         </form>
        </div>
    
    