
package servleti;

import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.UpitiBaza;

/**
 *
 * @author Aleksandar Djalovic
 */
public class rezervisiPoDatumu extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   //   PrintWriter pw=response.getWriter();
       HttpSession sesija = request.getSession();
      String idTerm=request.getParameter("idter");
      String brkar=request.getParameter("karte" );
      int idKorisnika=(int)sesija.getAttribute("id");
      int ukupno=Integer.parseInt(request.getParameter("ukupno"));
      int brojUlaznica=Integer.parseInt(brkar);
      int idTermina=Integer.parseInt(idTerm);
      int noviBroj=ukupno-brojUlaznica;
      String ime=null;
      for(Korisnik k:UpitiBaza.vratiKorisnike()){
          if(k.getIdKorisnika()==idKorisnika){
              ime=k.getUsername();
          }
      }
  //    pw.println("id termina je:"+idTerm+" ,broj karata: "+brkar+",korisnik "+idKorisnika+",ukupno"+ukupno+"noviBroj"+noviBroj);
      String poruka;
  if(brojUlaznica<=0||brojUlaznica>ukupno){
      poruka="nema karata na raspolaganju";
  }else{
      UpitiBaza.azurirajKarte(noviBroj,idTermina);
      UpitiBaza.rezervisi(brojUlaznica, idKorisnika, idTermina);
      poruka = ime+" ,uspesno ste rezervisali  "+brojUlaznica+" karata za zeljeni termin";
  }
  request.setAttribute("poruka", poruka);
  request.getRequestDispatcher("/view2/pretragaPoDatumima.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
