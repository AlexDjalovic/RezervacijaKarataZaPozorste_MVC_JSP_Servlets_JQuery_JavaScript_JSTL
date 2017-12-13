/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DB;

/**
 *
 * @author Aleksandar Djalovic
 */
public class Registracija extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String korIme = request.getParameter("rki");
    String lozinka = request.getParameter("rl");
    String telefon = request.getParameter("rt");
    String status=request.getParameter("yes/no");
    
    System.out.println(telefon+" "+status);
    
    String poruka = "";
    String adresa = "index.jsp";
    
        Korisnik k = new Korisnik();
        k.setUsername(korIme);
        k.setPassword(lozinka);
        k.setTelefon(telefon);
        k.setKategorija(status);
     
     if (korIme.isEmpty() || lozinka.isEmpty() || telefon.isEmpty()) {
      poruka = "Molimo Vas da popunite sva polja.";
    } else {
         Connection con = DB.getInstance().getConnection();
         if (con == null) {
             poruka = "Došlo je do greške u radu sa bazom.<br />"
                     + "Molimo pokušajte kasnije. ";
             request.setAttribute("poruka", poruka);
             request.getRequestDispatcher("error.jsp").forward(request, response);
             return;
         }
          Statement stmt = null;

      try {
        stmt = con.createStatement();

        String upit = "select username,password,telefon  from korisnik "
                + " where username='" + korIme + "';";
        ResultSet rs = stmt.executeQuery(upit);

        if (rs.next()) {
          poruka = "Postoji korisnik sa tim korisničkim imenom.";
            System.out.println(rs.getString("username"));
          k.setUsername("");
          k.setPassword("");
        } else {
          upit = "insert into korisnik (username,password,telefon,kategorija)"
                  + "values ('" + k.getUsername()+ "', '" + k.getPassword() + "', '" + k.getTelefon()+ "', '" + k.getKategorija() + "');";
          stmt.executeUpdate(upit);

          poruka = "Registrovani ste kao novi korisnik.";
          k.setUsername("");
          k.setPassword("");
          k.setTelefon("");
          k.setKategorija(korIme);
        }

        stmt.close();

      } catch (SQLException ex) {
        Logger.getLogger(Registracija.class.getName()).log(Level.SEVERE, null, ex);
        if (con == null) {
          poruka = "Došlo je do greške u radu sa bazom.<br />"
                  + "Molimo pokušajte kasnije.";
          request.setAttribute("poruka", poruka);
          request.getRequestDispatcher("error.jsp").forward(request, response);
          return;
        }
      } finally {
        DB.getInstance().putConnection(con);
      }
     }
     
        request.setAttribute("korisnik", k);
        request.setAttribute("poruka", poruka);
        request.getRequestDispatcher(adresa).forward(request, response);
     
     
     
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
