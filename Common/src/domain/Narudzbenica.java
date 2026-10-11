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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Narudzbenica implements Serializable {

    private int sifraNarudzbenice;
    private double ukupnaKolicina;
    private double ukupnaCenaSaPdv;
    private double ukupnaCenaBezPdv;
    private Date datum;
    private Musterija musterija;
    private List<StavkaNarudzbenice> stavke = new ArrayList<>();

    public Narudzbenica() {
    }

    public int getSifraNarudzbenice() {
        return sifraNarudzbenice;
    }

    public void setSifraNarudzbenice(int sifraNarudzbenice) {
        this.sifraNarudzbenice = sifraNarudzbenice;
    }

    public double getUkupnaKolicina() {
        return ukupnaKolicina;
    }

    public void setUkupnaKolicina(double ukupnaKolicina) {
        this.ukupnaKolicina = ukupnaKolicina;
    }

    public double getUkupnaCenaSaPdv() {
        return ukupnaCenaSaPdv;
    }

    public void setUkupnaCenaSaPdv(double ukupnaCenaSaPdv) {
        this.ukupnaCenaSaPdv = ukupnaCenaSaPdv;
    }

    public double getUkupnaCenaBezPdv() {
        return ukupnaCenaBezPdv;
    }

    public void setUkupnaCenaBezPdv(double ukupnaCenaBezPdv) {
        this.ukupnaCenaBezPdv = ukupnaCenaBezPdv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public List<StavkaNarudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaNarudzbenice> stavke) {
        this.stavke = stavke;
    }
}
