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
public class Materijal implements Serializable {
   
    private int materijalId;
    private String nazivMaterijala;
    private double cenaBezPdv;
    private double cenaSaPdv;
    private double stanje;
    private JedinicaMere jedinicaMere;
    private int pdvId;

    public Materijal() {
    }

    public int getMaterijalId() {
        return materijalId;
    }

    public void setMaterijalId(int materijalId) {
        this.materijalId = materijalId;
    }

    public String getNazivMaterijala() {
        return nazivMaterijala;
    }

    public void setNazivMaterijala(String nazivMaterijala) {
        this.nazivMaterijala = nazivMaterijala;
    }

    public double getCenaBezPdv() {
        return cenaBezPdv;
    }

    public void setCenaBezPdv(double cenaBezPdv) {
        this.cenaBezPdv = cenaBezPdv;
    }

    public double getCenaSaPdv() {
        return cenaSaPdv;
    }

    public void setCenaSaPdv(double cenaSaPdv) {
        this.cenaSaPdv = cenaSaPdv;
    }

    public double getStanje() {
        return stanje;
    }

    public void setStanje(double stanje) {
        this.stanje = stanje;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public int getPdvId() {
        return pdvId;
    }

    public void setPdvId(int pdvId) {
        this.pdvId = pdvId;
    }

    @Override
    public String toString() {
        return nazivMaterijala;
    }
}

