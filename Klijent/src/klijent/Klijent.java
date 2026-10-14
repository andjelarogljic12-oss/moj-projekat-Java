/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package klijent;

import domain.Materijal;
import domain.Musterija;
import domain.Narudzbenica;
import domain.Odgovor;
import domain.StavkaNarudzbenice;
import domain.Valuta;
import domain.Zahtev;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Klijent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Komunikacija k = new Komunikacija();
            k.poveziSe();

            // TEST 1: treba da uspe (Cement 10, Bela boja 5)
            Odgovor o1 = k.posalji(new Zahtev("SACUVAJ_NARUDZBENICU", napraviNarudzbenicu(10, 5)));
            System.out.println("TEST 1: " + o1.isUspesno() + " - " + o1.getPoruka());

            // TEST 2: treba da pukne (Bela boja 9999, nema toliko na stanju)
            Odgovor o2 = k.posalji(new Zahtev("SACUVAJ_NARUDZBENICU", napraviNarudzbenicu(10, 9999)));
            System.out.println("TEST 2: " + o2.isUspesno() + " - " + o2.getPoruka());

            k.prekiniVezu();
        } catch (Exception e) {
            e.printStackTrace();
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
        boja.setNazivMaterijala("Bela boja");

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
