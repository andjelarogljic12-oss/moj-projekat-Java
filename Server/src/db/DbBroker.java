/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.JedinicaMere;
import domain.Materijal;
import domain.Musterija;
import domain.Narudzbenica;
import domain.StavkaNarudzbenice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class DbBroker {
    
    private static final String URL = "jdbc:mysql://localhost:3306/bazaprojekatnovo";
    private static final String KORISNIK = "root";
    private static final String LOZINKA = "";
    
    private Connection connection;
    
    public void otvoriKonekciju() throws SQLException {
        connection = DriverManager.getConnection(URL, KORISNIK, LOZINKA);
        connection.setAutoCommit(false);
    }
    
    public void commit() throws SQLException{
        connection.commit();
    }
    
    public void rollback() throws SQLException{
        connection.rollback();
    }
    
    public void zatvoriKonekciju() throws SQLException{
        if(connection != null){
            connection.close();
            
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    public int dodajNarudzbenicu(Narudzbenica n) throws SQLException {
        String upit = "INSERT INTO narudzbenica "
                + "(UkupnaKolicina, UkupnaCenaSaPdv, UkupnaCenaBezPdv, Datum, MusterijaID) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, n.getUkupnaKolicina());
            ps.setDouble(2, n.getUkupnaCenaSaPdv());
            ps.setDouble(3, n.getUkupnaCenaBezPdv());
            ps.setDate(4, new java.sql.Date(n.getDatum().getTime()));
            ps.setInt(5, n.getMusterija().getMusterijaId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        throw new SQLException("Baza nije vratila šifru narudžbenice");
    }

    public void dodajStavku(int sifraNarudzbenice, StavkaNarudzbenice s) throws SQLException {
        String upit = "INSERT INTO stavkaNarudzbenice "
                + "(SifraNarudzbenice, RedniBr, MaterijalID, IznosSaPdv, IznosBezPdv, Popust, Valuta, Kolicina) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(upit)) {
            ps.setInt(1, sifraNarudzbenice);
            ps.setInt(2, s.getRedniBr());
            ps.setInt(3, s.getMaterijal().getMaterijalId());
            ps.setDouble(4, s.getIznosSaPdv());
            ps.setDouble(5, s.getIznosBezPdv());
            ps.setDouble(6, s.getPopust());
            ps.setString(7, s.getValuta().name());
            ps.setDouble(8, s.getKolicina());
            ps.executeUpdate();
        }
    }

    // Smanjuje stanje materijala. Vraća 0 ako nema dovoljno na stanju.
    public int smanjiStanje(int materijalId, double kolicina) throws SQLException {
        String upit = "UPDATE materijal SET Stanje = Stanje - ? "
                + "WHERE MaterijalID = ? AND Stanje >= ?";
        try (PreparedStatement ps = connection.prepareStatement(upit)) {
            ps.setDouble(1, kolicina);
            ps.setInt(2, materijalId);
            ps.setDouble(3, kolicina);
            return ps.executeUpdate();
        }
    }
    
    public List<Materijal> vratiMaterijale() throws SQLException {
        List<Materijal> lista = new ArrayList<>();
        String upit = "SELECT MaterijalID, NazivMaterijala, CenaBezPdv, CenaSaPdv, "
                + "Stanje, JedinicaMere, PdvID FROM materijal ORDER BY NazivMaterijala";
        try (Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(upit)) {
            while (rs.next()) {
                Materijal m = new Materijal();
                m.setMaterijalId(rs.getInt("MaterijalID"));
                m.setNazivMaterijala(rs.getString("NazivMaterijala"));
                m.setCenaBezPdv(rs.getDouble("CenaBezPdv"));
                m.setCenaSaPdv(rs.getDouble("CenaSaPdv"));
                m.setStanje(rs.getDouble("Stanje"));
                m.setJedinicaMere(JedinicaMere.valueOf(rs.getString("JedinicaMere")));
                m.setPdvId(rs.getInt("PdvID"));
                lista.add(m);
            }
        }
        return lista;
    }
    
    public List<Musterija> vratiMusterije() throws SQLException{
        List<Musterija> lista = new ArrayList<>();
        
        String upit = "SELECT MusterijaID, PIB, NazivFirme, VrstaMaterijala, " + 
                "PotrebnaKolicina, JedinicaMere FROM musterija ORDER BY NazivFirme";
        try(Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(upit)){
            
            while (rs.next()){
                Musterija m = new Musterija();
                m.setMusterijaId(rs.getInt("MusterijaID"));
                m.setPib(rs.getInt("PIB"));
                m.setNazivFirme(rs.getString("NazivFirme"));
                m.setVrstaMaterijala(rs.getString("VrstaMaterijala"));
                m.setPotrebnaKolicina(rs.getDouble("PotrebnaKolicina"));
                m.setJedinicaMere(JedinicaMere.valueOf(rs.getString("JedinicaMere")));
                lista.add(m);
            }
        }
        return lista;
    }
    
}
