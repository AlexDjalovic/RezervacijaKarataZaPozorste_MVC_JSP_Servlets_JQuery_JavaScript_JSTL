<%-- 
    Document   : formicaPozoriste
    Created on : Nov 23, 2017, 5:27:56 PM
    Author     : Aleksandar Djalovic
--%>

<h1>forma da promenite podatke o pozoristu</h1>    <br><br>
        
        <form action="updatePozoriste" method="POST">
             <input type="hidden" name="id" value="${pozoriste.idPozorista}"/>
              <table>
                <tr>
                <td>naziv pozorista:</td>
                <td><input type="text" name="tfnazPoz" value="${pozoriste.nazivPozorista}" /></td>
                </tr>
                  <tr>
                <td>adresa:</td>
                <td><input type="text" name="tfadres" value="${pozoriste.adresa}" /></td>
                </tr>
            <tr>
                    <td colspan="2"><input type="submit" value="promeni" /></td>
                </tr>
              </table>
            
            
            
            
            
            
        </form>
  
