/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author HP
 */
import java.io.Serializable;

public class StavkaNarudzbenice implements Serializable {

    private int redniBr;
    private Materijal materijal;
    private double iznosSaPdv;
    private double iznosBezPdv;
    private double popust;
    private Valuta valuta;
    private double kolicina;

    public StavkaNarudzbenice() {
    }

    public int getRedniBr() {
        return redniBr;
    }

    public void setRedniBr(int redniBr) {
        this.redniBr = redniBr;
    }

    public Materijal getMaterijal() {
        return materijal;
    }

    public void setMaterijal(Materijal materijal) {
        this.materijal = materijal;
    }

    public double getIznosSaPdv() {
        return iznosSaPdv;
    }

    public void setIznosSaPdv(double iznosSaPdv) {
        this.iznosSaPdv = iznosSaPdv;
    }

    public double getIznosBezPdv() {
        return iznosBezPdv;
    }

    public void setIznosBezPdv(double iznosBezPdv) {
        this.iznosBezPdv = iznosBezPdv;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }
}
