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
public class Zahtev implements Serializable{
    
    private String operacija;
    private Object podaci;

    public Zahtev() {
    }

    public Zahtev(String operacija, Object podaci) {
        this.operacija = operacija;
        this.podaci = podaci;
    }

    public String getOperacija() {
        return operacija;
    }

    public void setOperacija(String operacija) {
        this.operacija = operacija;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
    
    
}
