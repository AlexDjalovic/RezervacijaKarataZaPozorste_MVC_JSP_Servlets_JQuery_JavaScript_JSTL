
package servleti;

import beans.predstava;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.UpitiBaza;


public class insertterminServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String dan = request.getParameter("dan"); int d1=Integer.parseInt(dan);
        String mes = request.getParameter("mesec"); int m1=Integer.parseInt(mes);
        String god = request.getParameter("god");int g1=Integer.parseInt(god);
        String datum = god + "-" + mes + "-" + dan;
     //  Date d=new Date();   //SA STARIJOM VERZIJOM PRE JAVE 8
     
     //OD JAVE 8 OVO SE KORISTI
       LocalDate ld=LocalDate.now();
       LocalDate izabrani=LocalDate.of(g1, m1, d1);
       
        int brKarata = Integer.parseInt(request.getParameter("tfkarte"));
        String predstava = request.getParameter("combo1");
        int idPredstave = 0;
        for (predstava p : UpitiBaza.vratiPredstave()) {
            if (p.getNazivPredstave().equalsIgnoreCase(predstava)) {
                idPredstave = p.getIdPredstave();
            }
        }
          

        String adresa = "/view2/termin.jsp";
        //   if (d.before(new Date(g1, m1, d1))) {  //SA STARIJOM VERZIJOM PRE JAVE 8
        if (izabrani.isAfter(ld)) {
            UpitiBaza.insertTermin(datum, brKarata, idPredstave);

        } else {
            String poruka = "datum koji ste uneli je pre danasnjeg datuma";
            request.setAttribute("poruka", poruka);

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
