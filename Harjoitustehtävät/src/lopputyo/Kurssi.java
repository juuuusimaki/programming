package lopputyo;

import java.sql.*;
import java.lang.*;

public class Kurssi {

    // Attribuutit
    private int kurssi_id;
    private String nimi;
    private int opintopisteet;
    private String kuvaus;

    // Konstruktori
    public Kurssi () {

    }

    public Kurssi(int kurssi_id, String nimi, int opintopisteet, String kuvaus) {
        this.kurssi_id = kurssi_id;
        this.nimi = nimi;
        this.opintopisteet = opintopisteet;
        this.kuvaus = kuvaus;
    }

    // Metodit
    // Getterit ja setterit


    public int getKurssi_id() {
        return kurssi_id;
    }

    public void setKurssi_id(int kurssi_id) {
        this.kurssi_id = kurssi_id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getOpintopisteet() {
        return opintopisteet;
    }

    public void setOpintopisteet(int opintopisteet) {
        this.opintopisteet = opintopisteet;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    @Override
    public String toString() {
        return("Kurssitunnus: " + kurssi_id + ", nimi: " + nimi + ", opintopisteet: " + opintopisteet + ", kuvaus: " + kuvaus);
    }


    /*
    Haetaan tiedot ja palautetaan kurssiolio.
    */

       public Kurssi haeKurssi(Connection connection, int id, Kurssi kurssi) throws SQLException, Exception {
        // Haetaan SQL-tietokannasta kurssia ID:n perusteella
        String sql = "SELECT kurssi_id, nimi, opintopisteet, kuvaus FROM kurssi WHERE kurssi_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PrepareStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, id); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos kurssia ei löydy ID:llä
            if (!tulosjoukko.isBeforeFirst()) {
                throw new Exception("Kurssia ei loytynyt kurssitunnuksen " + id + " perusteella. \n");
            }
        }
        catch (Exception e) {
            throw e;
        }


        /*
        Käsitellään saatu tulosjoukko, ja sijoitetaan tiedot kurssiolioon
         */

        try {
            if (tulosjoukko.next()) {
                kurssi.setKurssi_id(tulosjoukko.getInt("kurssi_id"));
                kurssi.setNimi(tulosjoukko.getString("nimi"));
                kurssi.setOpintopisteet(tulosjoukko.getInt("opintopisteet"));
                kurssi.setKuvaus(tulosjoukko.getString("kuvaus"));
            }
        } catch (SQLException se) {
            throw se;
        }
        return kurssi;
    }

    /*
    Lisätään kurssin tiedot tietokantaan. Parametrina tietokantayhteys.
     */

    public int lisaaKurssi(Connection connection) throws SQLException, Exception {
        // Haetaan tietokannasta kurssia, jonka id vastaa olion id:tä. Jos id on jo kannassa, oliota ei lisätä.
        String sql = "SELECT kurssi_id" + " FROM kurssi WHERE kurssi_id = ?"; // WHERE-ehto toteutetaan taas myöhemmin
        // Suoritetaan SQL-lause
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getKurssi_id()); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            if (tulosjoukko.next()) { throw new Exception("Tunnus " + getKurssi_id() + " on jo tallennettu jarjestelmaan.");
            }
        }
        // Napataan SQL-virheet
        catch (SQLException se) {
            throw se;
        }
        // Napataan muut virheet
        catch (Exception e) {
            throw e;
        }

        // Kootaan INSERT-lause tietojen syöttöä varten
        sql = "INSERT INTO kurssi (kurssi_id, nimi, opintopisteet, kuvaus)" + "VALUES (?, ?, ?, ?)";

        System.out.println("Ajetaan SQL-lause muodossa " + sql);

        lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getKurssi_id());
            lause.setString(2, getNimi());
            lause.setInt(3, getOpintopisteet());
            lause.setString(4, getKuvaus());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Kurssin lisaaminen ei onnistu. \n");
            }
            else {
                throw new Exception("Kurssin lisaaminen onnistui. \n");
            }

        }

        // Napataan SQL-virheet
        catch (SQLException se) {
            throw se;
        }
        // Napataan muut virheet
        catch (Exception e) {
            throw e;
        }
    }

     /*
    Muutetaan kurssin tietoja tunnusta (id) lukuunottamatta.
     */

    public int muutaKurssi (Connection connection) throws SQLException, Exception {
        // Haetaan tietokannasta kurssia, jossa kurssi_id = kurssiolion id
        String sql = "SELECT kurssi_id"
                + " FROM kurssi WHERE kurssi_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getKurssi_id()); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos kurssia ei löydy
            if (!tulosjoukko.next()) {
                throw new Exception("Tunnusta " + kurssi_id + " vastaavaa kurssia ei ole loydy.");
            }
        }
        // Napataan SQL-virheet
        catch (SQLException se) {
            throw se;
        }
        // Napataan muut virheet
        catch (Exception e) {
            throw e;
        }

        // Kootaan UPDATE-lause, jossa päivitetään tiedot tunnusta lukuunottamatta
        sql = "UPDATE  kurssi "
                + "SET nimi = ?, opintopisteet = ?, kuvaus = ?"
                + " WHERE kurssi_id = ?";

        System.out.println("Syotetaan annetut tiedot lauseeseen " + sql);

        lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);

            lause.setString(1, getNimi());
            lause.setInt(2, getOpintopisteet());
            lause.setString(3, getKuvaus());
            lause.setInt(4, getKurssi_id());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Tunnusta " + kurssi_id + " vastaavien tietojen muuttaminen ei onnistu. \n");
            }
            else {
                System.out.println("Tunnusta " + kurssi_id + " vastaavan kurssin tietojen muuttaminen onnistui. \n");
            }
        }
        // Napataan SQL-virheet
        catch (SQLException se) {
            throw se;
        }
        // Napataan muut virheet
        catch (Exception e) {
            throw e;
        }
        return 0;
    }

    public int poistaKurssi(Connection connection) throws SQLException, Exception {

        // Kootaan DELETE-lause, jolla kurssi poistetaan tietokannasta.
        String sql = "DELETE FROM kurssi WHERE kurssi_id = ?";
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);

            // Sijoitetaan arvo WHERE-ehdolle
            lause.setInt(1, getKurssi_id());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Tunnusta " + kurssi_id + " vastaavan kurssin poistaminen ei onnistu. \n");
            } else {
                System.out.println("Tunnusta " + kurssi_id + " vastaavan kurssin poistaminen onnistui. \n");
            }
        }
        // Napataan SQL-virheet
        catch (SQLException se) {
            throw se;
        }
        // Napataan muut virheet
        catch (Exception e) {
            throw e;
        }
        return 0;
    }
}


