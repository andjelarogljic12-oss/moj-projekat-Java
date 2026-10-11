/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import db.DbBroker;

import domain.Materijal;
import domain.Musterija;
import domain.Narudzbenica;
import domain.StavkaNarudzbenice;
import domain.Valuta;
import java.util.Date;
import kontroler.Kontroler;

public class Server {

    public static void main(String[] args) {
        Kontroler kontroler = new Kontroler();

        // TEST 1: treba da uspe (Cement 10, Boja 5)
        try {
            kontroler.sacuvajNarudzbenicu(napraviNarudzbenicu(10, 5));
            System.out.println("TEST 1: sacuvano");
        } catch (Exception e) {
            System.out.println("TEST 1: greska: " + e.getMessage());
        }

        // TEST 2: treba da pukne (Cement 10, Boja 9999 - nema toliko na stanju)
        try {
            kontroler.sacuvajNarudzbenicu(napraviNarudzbenicu(10, 9999));
            System.out.println("TEST 2: sacuvano");
        } catch (Exception e) {
            System.out.println("TEST 2: greska (ocekivano): " + e.getMessage());
        }
    }

    private static Narudzbenica napraviNarudzbenicu(double kolicinaCementa, double kolicinaBoje) {
        Musterija m = new Musterija();
        m.setMusterijaId(1);

        Materijal cement = new Materijal();
        cement.setMaterijalId(1);
        cement.setNazivMaterijala("Cement");

        Materijal boja = new Materijal();
        boja.setMaterijalId(2);
        boja.setNazivMaterijala("Boja");

        Narudzbenica n = new Narudzbenica();
        n.setMusterija(m);
        n.setDatum(new Date());
        n.setUkupnaKolicina(kolicinaCementa + kolicinaBoje);
        n.setUkupnaCenaBezPdv(100);
        n.setUkupnaCenaSaPdv(120);

        n.getStavke().add(napraviStavku(cement, kolicinaCementa));
        n.getStavke().add(napraviStavku(boja, kolicinaBoje));
        return n;
    }

    private static StavkaNarudzbenice napraviStavku(Materijal materijal, double kolicina) {
        StavkaNarudzbenice s = new StavkaNarudzbenice();
        s.setMaterijal(materijal);
        s.setKolicina(kolicina);
        s.setIznosBezPdv(100);
        s.setIznosSaPdv(120);
        s.setPopust(0);
        s.setValuta(Valuta.DIN);
        return s;
    }
}