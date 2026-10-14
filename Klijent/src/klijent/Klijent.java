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
import java.util.List;

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

            Odgovor o1 = k.posalji(new Zahtev("VRATI_MATERIJALE", null));
            List<Materijal> materijali = (List<Materijal>) o1.getPodaci();
            System.out.println("MATERIJALI (" + materijali.size() + "):");
            for (Materijal m : materijali) {
                System.out.println("  " + m.getMaterijalId() + " | " + m.getNazivMaterijala()
                        + " | stanje: " + m.getStanje() + " " + m.getJedinicaMere());
            }

            Odgovor o2 = k.posalji(new Zahtev("VRATI_MUSTERIJE", null));
            System.out.println("ODGOVOR: " + o2.isUspesno() + " - " + o2.getPoruka());
            List<Musterija> musterije = (List<Musterija>) o2.getPodaci();
            System.out.println("MUSTERIJE (" + musterije.size() + "):");
            for (Musterija m : musterije) {
                System.out.println("  " + m.getMusterijaId() + " | " + m.getNazivFirme()
                        + " | PIB: " + m.getPib());
            }

            k.prekiniVezu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
