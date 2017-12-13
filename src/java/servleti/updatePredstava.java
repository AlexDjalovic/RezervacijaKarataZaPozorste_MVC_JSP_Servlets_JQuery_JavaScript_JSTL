/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.pozoriste;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.UpitiBaza;


public class updatePredstava extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       int ide = Integer.parseInt(request.getParameter("id"));
         String naziv=request.getParameter("tfnazPred" );
         String rez=request.getParameter("tfrez");
         String glumci=request.getParameter("tfglum");
         String pozoristen=request.getParameter("combo1");
         int idPoz=0;
         for(pozoriste p:UpitiBaza.vratiPozorista()){
             if(pozoristen.equalsIgnoreCase(p.getNazivPozorista())){
                 idPoz=p.getIdPozorista();
             }
         }
      /*  PrintWriter pw=response.getWriter();
         pw.print(naziv+" "+glumci+" "+ide+" "+pozoriste);*/
      UpitiBaza.updatePredstava(naziv,rez,glumci,idPoz,ide);
      request.getRequestDispatcher("/view2/predstava.jsp").forward(request, response);
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
