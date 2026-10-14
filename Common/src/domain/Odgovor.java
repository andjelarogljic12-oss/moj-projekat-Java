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
public class Odgovor implements Serializable{
    
    private boolean uspesno;
    private String poruka;
    private Object podaci;

    public Odgovor() {
    }

    public Odgovor(boolean uspesno, String poruka, Object podaci) {
        this.uspesno = uspesno;
        this.poruka = poruka;
        this.podaci = podaci;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
    
    
}
