/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Aleksandar Djalovic
 */
public class predstava {
    private int idPredstave,idPozorista;
    private String nazivPredstave,reziser,glumci;

    public predstava() {
    }

    public int getIdPredstave() {
        return idPredstave;
    }

    public void setIdPredstave(int idPredstave) {
        this.idPredstave = idPredstave;
    }

    public int getIdPozorista() {
        return idPozorista;
    }

    public void setIdPozorista(int idPozorista) {
        this.idPozorista = idPozorista;
    }

    public String getNazivPredstave() {
        return nazivPredstave;
    }

    public void setNazivPredstave(String nazivPredstave) {
        this.nazivPredstave = nazivPredstave;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getGlumci() {
        return glumci;
    }

    public void setGlumci(String glumci) {
        this.glumci = glumci;
    }
    
    
}
