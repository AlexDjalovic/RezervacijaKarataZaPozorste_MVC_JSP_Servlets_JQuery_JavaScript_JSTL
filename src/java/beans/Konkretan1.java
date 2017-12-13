/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;



/**
 *
 * @author Aleksandar Djalovic
 */
public class Konkretan1 implements Serializable{
   private  int ukupanBrojKarata,idTermina;
    private String nazivPredstave,reziser,glumci,nazivPozorista;

    public Konkretan1() {
    }

    public int getUkupanBrojKarata() {
        return ukupanBrojKarata;
    }

    public void setUkupanBrojKarata(int ukupanBrojKarata) {
        this.ukupanBrojKarata = ukupanBrojKarata;
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

    public String getNazivPozorista() {
        return nazivPozorista;
    }

    public void setNazivPozorista(String nazivPozorista) {
        this.nazivPozorista = nazivPozorista;
    }

    public int getIdTermina() {
        return idTermina;
    }

    public void setIdTermina(int idTermina) {
        this.idTermina = idTermina;
    }
  
    
    
    
}
