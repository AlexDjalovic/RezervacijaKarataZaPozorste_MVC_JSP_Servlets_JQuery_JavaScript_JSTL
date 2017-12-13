/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Aleksandar Djalovic
 */
public class Termin {
    private int idTermina,idPredstave,ukupanBrojKarata;
    private Date datum;

    public int getIdTermina() {
        return idTermina;
    }

    public void setIdTermina(int idTermina) {
        this.idTermina = idTermina;
    }

    public int getIdPredstave() {
        return idPredstave;
    }

    public void setIdPredstave(int idPredstave) {
        this.idPredstave = idPredstave;
    }

    public int getUkupanBrojKarata() {
        return ukupanBrojKarata;
    }

    public void setUkupanBrojKarata(int ukupanBrojKarata) {
        this.ukupanBrojKarata = ukupanBrojKarata;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Termin() {
    }
    
    
}
