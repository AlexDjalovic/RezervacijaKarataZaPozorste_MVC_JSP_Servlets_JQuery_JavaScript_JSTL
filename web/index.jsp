<%-- 
    Document   : index
    Created on : Nov 14, 2017, 6:11:53 PM
    Author     : Aleksandar Djalovic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



        <%--ovde pocinje telo----%>

        <div id="telo">
            <%--  
            <div id="levakolona">leva kolona</div>
            <div id="desnakolona">desna kolona</div>
            
            ---%>
            <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'Prijava')">Prijava</button>
                <button class="tablinks" onclick="openCity(event, 'Regisrtracija')">Regisrtracija</button>

            </div>

            <div id="Prijava" class="tabcontent">

                <form action="LoginServlet" method="post"class="IndexForma">
                    <br>
                    <table class="indexTable">
                        <tr>
                            <td>Korisničko ime:</td>
                            <td><input type="text"  name="lki" style="width: 50%;"/></td>
                        </tr>
                        <tr>
                            <td>Lozinka:</td>
                            <td><input type="password"  name="ll" style="width: 50%;" /></td>
                        </tr>
                        
                        <tr>
                            <td> </td>
                            <td> </td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Uloguj se" style="width: 50%;" /></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div id="Regisrtracija" class="tabcontent">

                <br />
                <form action="Registracija" method="post" class="IndexForma">
                    <br>
                    <table class="indexTable">
                        <tr>
                            <td>Korisničko ime:</td>
                            <td><input type="text" value="${korisnik.username}" name="rki"style="width: 50%;" /></td>
                        </tr>
                        <tr>
                            <td>Lozinka:</td>
                            <td><input type="password" value="${korisnik.password}" name="rl"style="width: 50%;" /></td>
                        </tr>
                        <tr>
                            <td>Telefon</td>
                            <td><input type="text" value="${korisnik.telefon}" name="rt" style="width: 50%;"/></td>
                        </tr>
                       
                        <tr>
                            <td>   </td> 
                            <td>
                                <input type="radio" name="yes/no" value="korisnik" checked="checked" />korisnik
                                <input type="radio" name="yes/no" value="admin" />administator
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                        <td></td>
                        <td ><input type="submit" value="Registruj se" style="width: 50%;"></td>
                        </tr>
                    </table>
                </form>
               
            </div>


 <br />

                 <h4 style="color:red">,${poruka == null ? "" : poruka} 
                 </h4>

        </div>
              
        

        <script>
 function openCity(evt, cityName) {
     var i, tabcontent, tablinks;
     tabcontent = document.getElementsByClassName("tabcontent");
     for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " active";
            }
        </script> 

   
