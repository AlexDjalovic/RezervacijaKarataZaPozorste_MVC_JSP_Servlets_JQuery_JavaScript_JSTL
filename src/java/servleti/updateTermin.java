
package servleti;

import beans.pozoriste;
import beans.predstava;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.UpitiBaza;


public class updateTermin extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       int ide = Integer.parseInt(request.getParameter("id"));
       String datum=request.getParameter("tfdatum");
       int brojKarata= Integer.parseInt(request.getParameter("tfubk"));
       String predstava=request.getParameter("combo1");
       
        int idPred=0;
         for(predstava p:UpitiBaza.vratiPredstave()){
             if(p.getNazivPredstave().equalsIgnoreCase(predstava)){
                 idPred=p.getIdPredstave();
             }
         }
         UpitiBaza.updateTermin(datum,brojKarata,idPred,ide);
      request.getRequestDispatcher("/view2/termin.jsp").forward(request, response);
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
