package lopputyo;

import java.sql.*;
import java.lang.*;

public class Opiskelija {

    // Attribuutit
    private int opiskelija_id;
    private String etunimi;
    private String sukunimi;
    private String lahiosoite;
    private String postitoimipaikka;
    private String postinumero;
    private String sahkoposti;
    private String puhelinnumero;

    // Konstruktori
    public Opiskelija(){

    }

    public Opiskelija(int opiskelija_id, String etunimi, String sukunimi, String lahiosoite, String postitoimipaikka, String postinumero, String sahkoposti, String puhelinnumero) {
        this.opiskelija_id = opiskelija_id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.lahiosoite = lahiosoite;
        this.postitoimipaikka = postitoimipaikka;
        this.postinumero = postinumero;
        this.sahkoposti = sahkoposti;
        this.puhelinnumero = puhelinnumero;
    }

    // Metodit
    // Getterit ja setterit

    public int getOpiskelija_id() {
        return opiskelija_id;
    }

    public void setOpiskelija_id(int opiskelija_id) {
        this.opiskelija_id = opiskelija_id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getLahiosoite() {
        return lahiosoite;
    }

    public void setLahiosoite(String lahiosoite) {
        this.lahiosoite = lahiosoite;
    }

    public String getPostitoimipaikka() {
        return postitoimipaikka;
    }

    public void setPostitoimipaikka(String postitoimipaikka) {
        this.postitoimipaikka = postitoimipaikka;
    }

    public String getPostinumero() {
        return postinumero;
    }

    public void setPostinumero(String postinumero) {
        this.postinumero = postinumero;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    @Override
    public String toString() {
        return("Opiskelijatunnus: " + opiskelija_id + ", etunimi: " + etunimi + ", sukunimi: " + sukunimi + ", lahiosoite: " + lahiosoite + ", postitoimipaikka: " + postitoimipaikka +
                ", postinumero: " + postinumero + ", sahkoposti: " + sahkoposti + ", puhelinnumero: " + puhelinnumero);
    }

    /*
    Haetaan tiedot ja palautetaan opiskelijaolio.
    */

    public Opiskelija haeOpiskelija (Connection connection, int id, Opiskelija opiskelija) throws SQLException, Exception {
        // Haetaan SQL-tietokannasta opiskelijaa ID:n perusteella
        String sql = "SELECT opiskelija_id, etunimi, sukunimi, lahiosoite, postitoimipaikka, postinumero, sahkoposti, puhelinnumero "
                +" FROM opiskelija WHERE opiskelija_id = ?"; // WHERE-ehto annetaan myöhemmin
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PrepareStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, id); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos opiskelijaa ei löydy ID:llä
            if (!tulosjoukko.isBeforeFirst()) {
                throw new Exception("Opiskelijaa ei loytynyt opiskelijatunnuksen " + id + " perusteella. \n");
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

        /*
        Käsitellään saatu tulosjoukko, ja sijoitetaan tiedot opiskelijaolioon
         */

        try {

            // Jos tuloksissa on vielä seuraava rivi, asetetaan tietoja settereillä

            if(tulosjoukko.next()) {
                opiskelija.setOpiskelija_id(tulosjoukko.getInt("opiskelija_id"));
                opiskelija.setEtunimi(tulosjoukko.getString("etunimi"));
                opiskelija.setSukunimi(tulosjoukko.getString("sukunimi"));
                opiskelija.setLahiosoite(tulosjoukko.getString("lahiosoite"));
                opiskelija.setPostitoimipaikka(tulosjoukko.getString("postitoimipaikka"));
                opiskelija.setPostinumero(tulosjoukko.getString("postinumero"));
                opiskelija.setSahkoposti(tulosjoukko.getString("sahkoposti"));
                opiskelija.setPuhelinnumero(tulosjoukko.getString("puhelinnumero"));
            }
        }
        catch (SQLException se) {
            throw se;
        }

        // Palautetaan opiskelijaolio
        return opiskelija;
    }

    /*
    Lisätään opiskelijan tiedot tietokantaan. Parametrina tietokantayhteys.
     */

    public int lisaaOpiskelija(Connection connection) throws SQLException, Exception {
        // Haetaan tietokannasta opiskelijaa, jonka id vastaa olion id:tä. Jos id on jo kannassa, oliota ei lisätä.
        String sql = "SELECT opiskelija_id" + " FROM opiskelija WHERE opiskelija_id = ?"; // WHERE-ehto toteutetaan taas myöhemmin
        // Suoritetaan SQL-lause
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getOpiskelija_id()); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            if (tulosjoukko.next()) {
                throw new Exception("Tunnus " + getOpiskelija_id() + " on jo tallennettu jarjestelmaan.");
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
        sql = "INSERT INTO Opiskelija" +
                "(opiskelija_id, etunimi, sukunimi, lahiosoite, postitoimipaikka, postinumero, sahkoposti, puhelinnumero) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println("Ajetaan SQL-lause muodossa " + sql);

        lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getOpiskelija_id());
            lause.setString(2, getEtunimi());
            lause.setString(3, getSukunimi());
            lause.setString(4, getLahiosoite());
            lause.setString(5, getPostitoimipaikka());
            lause.setString(6, getPostinumero());
            lause.setString(7, getSahkoposti());
            lause.setString(8, getPuhelinnumero());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Opiskelijan lisaaminen ei onnistu.");
            }
            else {
                System.out.println("Tunnusta " + opiskelija_id + " vastaavan opiskelijan lisaaminen onnistui. \n");
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

    /*
    Muutetaan opiskelijan tietoja tunnusta (id) lukuunottamatta.
     */

    public int muutaOpiskelija (Connection connection) throws SQLException, Exception {
        // Haetaan tietokannasta opiskelijaa, jossa opiskelija_id = opiskelijaolion id
        String sql = "SELECT opiskelija_id"
                + " FROM opiskelija WHERE opiskelija_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getOpiskelija_id()); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos opiskelijaa ei löydy
            if (!tulosjoukko.next()) {
                throw new Exception("Tunnusta " + opiskelija_id + " vastaavaa opiskelijaa ei ole tietokannassa.");
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
        sql = "UPDATE  Opiskelija "
                + "SET etunimi = ?, sukunimi = ?, lahiosoite = ?, postitoimipaikka = ?, postinumero = ?, sahkoposti = ?, puhelinnumero = ? "
                + " WHERE opiskelija_id = ?";

        System.out.println("Syotetaan annetut tiedot lauseeseen " + sql);

        lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);

            lause.setString(1, getEtunimi());
            lause.setString(2, getSukunimi());
            lause.setString(3, getLahiosoite());
            lause.setString(4, getPostitoimipaikka());
            lause.setString(5, getPostinumero());
            lause.setString(6, getSahkoposti());
            lause.setString(7, getPuhelinnumero());
            lause.setInt(8, getOpiskelija_id());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Tunnusta " + opiskelija_id + " vastaavien tietojen muuttaminen ei onnistu. \n");
            }
            else {
                System.out.println("Tunnusta " + opiskelija_id + " vastaavan opiskelijan tietojen muuttaminen onnistui. \n");
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

    /*
    Poistetaan opiskelijan tiedot tietokannasta.
     */

    public int poistaOpiskelija (Connection connection) throws SQLException, Exception {

        // Kootaan DELETE-lause, jolla opiskelija poistetaan tietokannasta.
        String sql = "DELETE FROM opiskelija WHERE opiskelija_id = ?";
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);

            // Sijoitetaan arvo WHERE-ehdolle
            lause.setInt(1, getOpiskelija_id());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Tunnusta " + opiskelija_id + " vastaavan opiskelijan poistaminen ei onnistu. \n");
            } else {
                System.out.println("Tunnusta " + opiskelija_id + " vastaavan opiskelijan poistaminen onnistui. \n");
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










