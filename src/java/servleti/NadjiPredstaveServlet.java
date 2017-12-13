/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.Konkretan1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.UpitiBaza;


public class NadjiPredstaveServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String datum = request.getParameter("combo12");

        //OVO JE BILA PROVERA
        //   PrintWriter pw=response.getWriter();      
        //     HttpSession  sesija =request.getSession();
        //       int id=(int)sesija.getAttribute("id");
        //    pw.print(datum+" \n ");
        ArrayList<Konkretan1> al = UpitiBaza.vratiRezultatzaDatiDatum(datum);
        //  pw.print(al);
        HttpSession sesija = request.getSession();
        /*    for(Konkretan1 k1:al){
             
           //  pw.println(k1.getNazivPredstave()+" "+datum+"<br>");
         }*/
        
        request.setAttribute("datum", datum);
        sesija.setAttribute("al", al);
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
