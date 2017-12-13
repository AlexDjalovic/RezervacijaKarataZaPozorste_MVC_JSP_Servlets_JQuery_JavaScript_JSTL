<%-- 
    Document   : pretragaPoDatumima
    Created on : Nov 27, 2017, 5:51:54 PM
    Author     : Aleksandar Djalovic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <h1>Pretraga po datumima</h1>
        <form  name="forma" id="forma12" action="NadjiPredstaveServlet" method="post" style="margin: auto">
            <select name="combo12" id="combo12"onchange="myF()">
                   <option>Izaberi datum: </option>
                <c:forEach var="da" items="${datumi}">
                    <%-- ako treba da pretrazujem listu  ne treba mi rows!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! to vazi samo ako koristim c:sql jer onda pretrazujem resultset---%>              
                    <option>${da}</option>
                </c:forEach>
            </select>
        </form>
        <%--
        <form name="forma1" action="rezervisiPoDatumu" method="post" >
            <br>
            REZULTATI ZA ${datum}
            <c:forEach var="xx" items="${al}">
                <div class="oblacici" id="" >
                    <input type="text" name="idter" id="idter"value="${xx.idTermina}" /><br>
                    Pozoriste: ${xx.nazivPozorista}<br>
                    Predstava: ${xx.nazivPredstave}<br>
                    reziser:${xx.reziser}<br>
                    glumci:${xx.glumci}<br>   
                    broj slobodnih karata:${xx.ukupanBrojKarata}<br>
                  uneti broj karata koji zelite da rezervisete:  <input type="text" name="trazeniBR" value="" onfocusout="pokupi()"/>
                  <input type="hidden" name="ukupno" value="${xx.ukupanBrojKarata}" /><br>
                
                </div>
            </c:forEach>
        </form>
        --%>
         REZULTATI ZA ${datum}
        <c:forEach var="xx" items="${al}">
            <div class="oblacici">
                <input type="hidden" name="idter" id="idter"value="${xx.idTermina}" /><br>
                Pozoriste: ${xx.nazivPozorista}<br>
                Predstava: ${xx.nazivPredstave}<br>
                reziser:${xx.reziser}<br>
                glumci:${xx.glumci}<br>   
                broj slobodnih karata:${xx.ukupanBrojKarata}<br>           
               uneti broj karata koji zelite da rezervisete:   <input type="text" name="karte" id="karte" value="" />         
                <input type="hidden" name="ukupno" value="${xx.ukupanBrojKarata}" /><br>
                <a id="vezica" href="rezervisiPoDatumu?idter=${xx.idTermina}&ukupno=${xx.ukupanBrojKarata}&karte=" >REZERVISI</a>
            </div>           
        </c:forEach>
                 ${poruka}

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script>
        function myF(){
            document.forma.submit();
        }
            
                
        $(document).ready(function(){
        $(function(){
$(".oblacici").click(function(){
        $(this).addClass("selected");
});
});
});
       
   
  /*   $(document).ready(function(){
                $("a").click(function(){
                  input=$("#karte").val();
                  //var xyz=new String(input).toString();              
         $("a").attr("href",function(i,val){
             return val+input;
         });
                });
            });*/
           
           //druga verzija skupljanja sa textinputa

    $(document).ready(function(){
        //klikom na oblacic
        $("div.oblacici").click(function () {
            //pokupi sa ovog oblacica sa inputa karte vrednost
    input=$(this).children("#karte").val();
    //dodaj u href da se prosledi na servlet pomocu attr()
          $("a").attr("href",function(i,val){
             return val+input;
         });
});
    });
            </script>

            
          
                
