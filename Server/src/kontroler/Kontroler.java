/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import db.DbBroker;
import domain.Narudzbenica;
import domain.StavkaNarudzbenice;

public class Kontroler {

    public void sacuvajNarudzbenicu(Narudzbenica n) throws Exception {
        DbBroker db = new DbBroker();
        try {
            db.otvoriKonekciju();

            int sifra = db.dodajNarudzbenicu(n);
            n.setSifraNarudzbenice(sifra);

            int redniBr = 1;
            for (StavkaNarudzbenice s : n.getStavke()) {
                s.setRedniBr(redniBr++);
                db.dodajStavku(sifra, s);

                int promenjeno = db.smanjiStanje(s.getMaterijal().getMaterijalId(), s.getKolicina());
                if (promenjeno == 0) {
                    throw new Exception("Nema dovoljno materijala: " + s.getMaterijal().getNazivMaterijala());
                }
            }

            db.commit();
        } catch (Exception e) {
            db.rollback();
            throw e;
        } finally {
            db.zatvoriKonekciju();
        }
    }
}
