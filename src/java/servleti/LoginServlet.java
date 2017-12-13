/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.UpitiBaza;


public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("lki");
        String password = request.getParameter("ll");
       // String kateg=request.getParameter("rbtn");
           String kateg=null;
       
        boolean provera=false;
        
        String adresa=null;
        for (Korisnik k : UpitiBaza.vratiKorisnike()) {

            if (k.getUsername().equalsIgnoreCase(username) && k.getPassword().equalsIgnoreCase(password)) {
                System.out.println(k.getUsername() + " " + k.getKategorija());
                provera = true;
                kateg=k.getKategorija();
                break;
            }
        }
        if (provera == true) {
            System.out.println("moram da proverim");

            if (kateg.equalsIgnoreCase("admin")) {
                adresa = "/view2/adminy.jsp";
            } else if (kateg.equalsIgnoreCase("korisnik")) {
                //saljem na rezervaciju username
                request.setAttribute("user", username);
                adresa = "/view2/rezervacija.jsp";
                
            }
        } else {
            String poruka = "NEMATE PRAVO PRISTUPA kao administrator,REGISTRUJTE SE";
            request.setAttribute("poruka", poruka);

            adresa = "index.jsp";
        }
        request.getRequestDispatcher(adresa).forward(request, response);
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
