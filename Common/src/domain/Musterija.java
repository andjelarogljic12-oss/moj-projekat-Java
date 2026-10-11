/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Musterija implements Serializable {
    private int musterijaId;
    private int pib;
    private String nazivFirme;
    private String vrstaMaterijala;
    private double potrebnaKolicina;
    private JedinicaMere jedinicaMere;

    public Musterija() {
    }
    
    public int getMusterijaId() {
        return musterijaId;
    }

    public void setMusterijaId(int musterijaId) {
        this.musterijaId = musterijaId;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }

    public String getVrstaMaterijala() {
        return vrstaMaterijala;
    }

    public void setVrstaMaterijala(String vrstaMaterijala) {
        this.vrstaMaterijala = vrstaMaterijala;
    }

    public double getPotrebnaKolicina() {
        return potrebnaKolicina;
    }

    public void setPotrebnaKolicina(double potrebnaKolicina) {
        this.potrebnaKolicina = potrebnaKolicina;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    @Override
    public String toString() {
        return nazivFirme;
    }
}
            

