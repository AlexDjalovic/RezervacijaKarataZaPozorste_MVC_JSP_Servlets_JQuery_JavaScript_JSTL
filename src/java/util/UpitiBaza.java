
package util;

import beans.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar Djalovic
 */
public class UpitiBaza {
     private static Connection con=  DB.getInstance().getConnection();
     
     
    public static ArrayList<Korisnik> vratiKorisnike() {
        ArrayList<Korisnik> al = new ArrayList<>();
        ResultSet rs = null;
        Statement s = null;
        String upit = "SELECT * FROM korisnik";
        try {
            s = con.createStatement();
            rs = s.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("idKorisnika");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String telefon = rs.getString("telefon");
                String kategorija = rs.getNString("kategorija");
                Korisnik k = new Korisnik();
                k.setIdKorisnika(id);
                k.setUsername(username);
                k.setPassword(password);
                k.setTelefon(telefon);
                k.setKategorija(kategorija);
                al.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DB.getInstance().putConnection(con);
        }
        return al;      
  }
    
    public static void insertPozoriste(String naziv,String adresa){
        String sql="INSERT INTO pozoriste(nazivPozorista,adresa)VALUES(?,?)";
         try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, naziv);
             ps.setString(2, adresa);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally{
             DB.getInstance().putConnection(con);
         }
    }
    public static void deletePozoriste(int id){
        String sql="DELETE FROM pozoriste WHERE idPozorista="+id;
         try {
            Statement ss = con.createStatement();
            ss.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
             DB.getInstance().putConnection(con);
         }
    }

    public static pozoriste izvadiPoKriterijumuPozoriste(int ide) {
       String sql="SELECT *FROM pozoriste WHERE idPozorista="+ide;
       pozoriste p=new pozoriste();
         try {
             Statement ss=con.createStatement();
             ResultSet rs=ss.executeQuery(sql);
             
             while(rs.next()){
                 p.setIdPozorista(rs.getInt("idPozorista"));
                 p.setNazivPozorista(rs.getString("nazivPozorista"));
                 p.setAdresa(rs.getString("adresa"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
         return p;
    }

    public static void updatePozoriste(String naziv, String adresa, int ide) {
        String update="UPDATE pozoriste SET nazivPozorista=?,adresa=?WHERE idPozorista=?";
         try {
             PreparedStatement ps= con.prepareStatement(update);
             ps.setString(1, naziv);
             ps.setString(2, adresa);
             ps.setInt(3, ide);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
    }
    public static ArrayList<pozoriste>vratiPozorista(){
        String sql="SELECT * FROM pozoriste";
        ArrayList<pozoriste>al=new ArrayList<>();
         try {
             Statement s=con.createStatement();
             ResultSet rs=s.executeQuery(sql);
             while(rs.next()){
                 int idPozorista=rs.getInt("idPozorista");
                 String naziv=rs.getString("nazivPozorista");
                 String adresa=rs.getString("adresa");
                 pozoriste p=new pozoriste();
                 p.setIdPozorista(idPozorista);
                 p.setAdresa(adresa);
                 p.setNazivPozorista(naziv);
                 al.add(p);
                         
             }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
         return al;
                
    }
     public static void insertPredstava(String naziv,String reziser,String glumci,int idPozorista){
        String sql="INSERT INTO predstava(nazivPredstave,reziser,glumci,idPozorista)VALUES(?,?,?,?)";
         try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, naziv);
             ps.setString(2, reziser);
             ps.setString(3, glumci);
             ps.setInt(4, idPozorista);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally{
             DB.getInstance().putConnection(con);
         }
    }
     public static predstava izvadiPoKriterijumuPredstavu(int ide) {
       String sql="SELECT *FROM predstava WHERE idPredstave="+ide;
       predstava p=new predstava();
         try {
             Statement ss=con.createStatement();
             ResultSet rs=ss.executeQuery(sql);
             
             while(rs.next()){
                 p.setIdPredstave(rs.getInt("idPredstave"));
                 p.setIdPozorista(rs.getInt("idPozorista"));
                 p.setNazivPredstave(rs.getString("nazivPredstave"));
                 p.setGlumci(rs.getString("glumci"));
                 p.setReziser(rs.getString("reziser"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
         return p;
    }

    public static void updatePredstava(String naziv, String rez, String glumci, int idPoz, int ide) {
       String update="UPDATE predstava SET nazivPredstave=?,reziser=?,glumci=?,idPozorista=? WHERE idPredstave=?";
       try {
             PreparedStatement ps= con.prepareStatement(update);
             ps.setString(1, naziv);
             ps.setString(2, rez);
             ps.setString(3,glumci);
             ps.setInt(4, idPoz);
             ps.setInt(5, ide);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
    }

    public static void deletePredstava(int ide) {
       String sql="DELETE FROM predstava WHERE idPredstave="+ide;
         try {
            Statement ss = con.createStatement();
            ss.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
             DB.getInstance().putConnection(con);
         }
    }
    public static ArrayList<predstava>vratiPredstave(){
        String sql="SELECT * FROM predstava";
        ArrayList<predstava>al=new ArrayList<>();
         try {
             Statement s=con.createStatement();
             ResultSet rs=s.executeQuery(sql);
             while(rs.next()){
                 int idPredstave=rs.getInt("idPredstave");
                 String naziv=rs.getString("nazivPredstave");
                 String reziser=rs.getString("reziser");
                 String glumci=rs.getString("glumci");
                 int idPozorista=rs.getInt("idPozorista");
                 predstava p=new predstava();
                 p.setIdPozorista(idPozorista);
                 p.setGlumci(glumci);
                 p.setNazivPredstave(naziv);
                 p.setReziser(reziser);
                 p.setIdPredstave(idPredstave);
                 al.add(p);
                         
             }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
         return al;
                
    }

    public static void insertTermin(String datum, int brKarata, int idPredstave) {
         String sql="INSERT INTO termin(Datum,ukupanBrojKarata,idPredstave)VALUES(?,?,?)";
         try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, datum);
             ps.setInt(2, brKarata);
             ps.setInt(3, idPredstave);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally{
             DB.getInstance().putConnection(con);
         }
    }

    public static void deleteTermin(int ide) {
        String sql="DELETE FROM termin WHERE idTermina="+ide;
         try {
            Statement ss = con.createStatement();
            ss.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
             DB.getInstance().putConnection(con);
         }
    }

    public static Termin izvadiPoKriterijumuTermin(int ide) {
        String sql="SELECT *FROM termin WHERE idTermina="+ide;
       Termin t=new Termin();
         try {
             Statement ss=con.createStatement();
             ResultSet rs=ss.executeQuery(sql);
             
             while(rs.next()){
                 t.setIdPredstave(rs.getInt("idPredstave"));
                t.setDatum(rs.getDate("Datum"));
               t.setIdTermina(rs.getInt("idTermina"));
                t.setUkupanBrojKarata(rs.getInt("ukupanBrojKarata"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
         return t;
    }

    public static void updateTermin(String datum, int brojKarata, int idPred, int ide) {
         String update="UPDATE termin SET Datum=?,ukupanBrojKarata=?,idPredstave=? WHERE idTermina=?";
       try {
             PreparedStatement ps= con.prepareStatement(update);
             ps.setString(1, datum);
           ps.setInt(2, brojKarata);
             ps.setInt(3, idPred);
             ps.setInt(4, ide);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
    }
     public static ArrayList<Termin> vratiTermine() {
        String sql="SELECT *FROM termin";
       Termin t=new Termin();
       ArrayList<Termin>al=new ArrayList<>();
         try {
             Statement ss=con.createStatement();
             ResultSet rs=ss.executeQuery(sql);
             
             while(rs.next()){
                 t.setIdPredstave(rs.getInt("idPredstave"));
                t.setDatum(rs.getDate("Datum"));
               t.setIdTermina(rs.getInt("idTermina"));
                t.setUkupanBrojKarata(rs.getInt("ukupanBrojKarata"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
         return al;
    }

    public static ArrayList<String>prikaziDatumeUKombo() {
        
        String upit="SELECT DISTINCT Datum FROM termin";
        ArrayList<String> datumi=new ArrayList<>();
        Statement ss;
         try {
             ss = con.createStatement();
             ResultSet rs=ss.executeQuery(upit);
              while(rs.next()){
                  String dat=rs.getString("Datum");
                  datumi.add(dat);
              }
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             DB.getInstance().putConnection(con);
         }
        
         return datumi;
      
    }

    public static ArrayList<Konkretan1> vratiRezultatzaDatiDatum(String datum) {
        ArrayList<Konkretan1> al = new ArrayList<>();
        String upit = "SELECT  t.idTermina,t.ukupanBrojKarata,p.nazivPredstave,p.reziser,p.glumci,poz.nazivPozorista FROM termin AS t INNER JOIN predstava AS p ON t.idPredstave=p.idPredstave INNER JOIN pozoriste AS poz ON p.idPozorista=poz.idPozorista WHERE t.Datum=?";

        try {
         //   Statement ss = con.createStatement();
         PreparedStatement ps=con.prepareStatement(upit);
         ps.setString(1, datum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Konkretan1 k1 = new Konkretan1();
                k1.setUkupanBrojKarata(rs.getInt("t.ukupanBrojKarata"));
                k1.setNazivPredstave(rs.getString("p.nazivPredstave"));
                k1.setReziser(rs.getString("p.reziser"));
                k1.setGlumci(rs.getString("p.glumci"));
                k1.setNazivPozorista(rs.getString("poz.nazivPozorista"));
                k1.setIdTermina(rs.getInt("idTermina"));
                al.add(k1);
              //  System.out.println(k1.getNazivPozorista());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             DB.getInstance().putConnection(con);
         }
        return al;
    }

    public static void rezervisi(int brojUlaznica, int idKorisnika, int idTermina) {
        String unos="INSERT INTO rezervacija(brojUlaznica,idKorisnika,idTermina)VALUES(?,?,?)";
         try {
             PreparedStatement ps=con.prepareStatement(unos);
             ps.setInt(1, brojUlaznica);
             ps.setInt(2,idKorisnika);
             ps.setInt(3, idTermina);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
}
    public static void azurirajKarte(int noviBroj,int idTermina){
        String update="UPDATE termin SET ukupanBrojKarata=? WHERE idTermina=?";
         try {
             PreparedStatement ps=con.prepareStatement(update);
             ps.setInt(1, noviBroj);
             ps.setInt(2,idTermina);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UpitiBaza.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
