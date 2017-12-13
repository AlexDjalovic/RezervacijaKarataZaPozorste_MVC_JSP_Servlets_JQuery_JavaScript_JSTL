<%-- 
    Document   : adminy
    Created on : Nov 22, 2017, 4:55:27 PM
    Author     : Aleksandar Djalovic
--%>


        
        <%--     <div id="adminyglavnidiv">
            <div class="adminydugmici"><a href="view2/pozoriste.jsp">informacije o pozoristu</a></div>
            <div class="adminydugmici"><a href="view2/predstava.jsp">informacije o predstavi</a></div>
            <div class="adminydugmici"><a href="view2/termin.jsp">termini</a></div>
        </div>
        --%>
        <div id="adminyglavnidiv">
            <form name="adminForma" action="Otvaranje3Forme" id="adminForma">
                <center>
                    <input type="radio" name="adminrb" value="pozoriste"  id="poz"/><b> informacije o pozoristu</b><br>
                <input type="radio" name="adminrb" value="predstava" id="pred"/><b>informacije o predstavama</b><br>
                <input type="radio" name="adminrb" value="termin" id="termin" /><b>informacije o terminima</b><br>
                <input type="submit" value="otvori zeljenu stranicu" />
                </center>
            </form>
        </div>
        
       
        <%-- ako hocu ovako preko linka da pozovem jsp strane morao sam da ih izvucem u novi folder view2 koji mora biti van WEB-INF jer tu ne moze da se pristupi --%>
        
        <%-- da je ostalo u WEB-INF morao bi preko servleta i request dispatchera --%>
        
        <%-- kod request dispatchera  mora   /VIEW2/XXX.JSP, dok kod hrefa ide samo view2/xxx.jsp--%>
        
        
        
        