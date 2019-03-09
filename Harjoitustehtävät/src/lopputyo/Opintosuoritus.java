package lopputyo;

import java.sql.*;
import java.lang.*;

public class Opintosuoritus {

    // Attribuutit
    private int opiskelija_id;
    private int kurssi_id;
    private int arvosana;
    private String suoritus_pvm;

    // Konstruktori
    public Opintosuoritus() {

    }

    public Opintosuoritus(int opiskelija_id, int kurssi_id, int arvosana, String suoritus_pvm) {
        this.opiskelija_id = opiskelija_id;
        this.kurssi_id = kurssi_id;
        this.arvosana = arvosana;
        this.suoritus_pvm = suoritus_pvm;
    }

    // Metodit
    // Getterit ja setterit


    public int getOpiskelija_id() {
        return opiskelija_id;
    }

    public void setOpiskelija_id(int opiskelija_id) {
        this.opiskelija_id = opiskelija_id;
    }

    public int getKurssi_id() {
        return kurssi_id;
    }

    public void setKurssi_id(int kurssi_id) {
        this.kurssi_id = kurssi_id;
    }

    public int getArvosana() {
        return arvosana;
    }

    public void setArvosana(int arvosana) {
        this.arvosana = arvosana;
    }

    public String getSuoritus_pvm() {
        return suoritus_pvm;
    }

    public void setSuoritus_pvm(String suoritus_pvm) {
        this.suoritus_pvm = suoritus_pvm;
    }

    @Override
    public String toString() {
        return ("Opiskelijatunnus: " + opiskelija_id + ", kurssitunnus: " + kurssi_id + ", arvosana: " + arvosana + ", suorituspaivamaara: " + suoritus_pvm);
    }

    /*
    Haetaan tiedot ja palautetaan opintosuoritusolio.
    */

    public Opintosuoritus haeOpintosuoritus(Connection connection, int opiskelija_id, int kurssi_id, Opintosuoritus opintosuoritus) throws SQLException, Exception {
        // Haetaan SQL-tietokannasta opintosuoritusta ID:n perusteella
        String sql = "SELECT  opiskelija_id, kurssi_id, arvosana, suoritus_pvm FROM opintosuoritus WHERE opiskelija_id = ? AND kurssi_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PrepareStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, opiskelija_id); // WHERE-ehdon arvo
            lause.setInt(2, kurssi_id);

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos opintosuoritusta ei löydy ID:llä
            if (!tulosjoukko.isBeforeFirst()) {
                throw new Exception("Opintosuoritusta ei loytynyt opiskelijatunnuksen " + opiskelija_id + " ja kurssitunnuksen " + kurssi_id + " perusteella. \n");
            }
        } catch (Exception e) {
            throw e;
        }


        /*
        Käsitellään saatu tulosjoukko, ja sijoitetaan tiedot opintosuoritusolioon.
         */

        try {
            if (tulosjoukko.next()) {
                opintosuoritus.setOpiskelija_id(tulosjoukko.getInt("opiskelija_id"));
                opintosuoritus.setKurssi_id(tulosjoukko.getInt("kurssi_id"));
                opintosuoritus.setArvosana(tulosjoukko.getInt("arvosana"));
                opintosuoritus.setSuoritus_pvm(tulosjoukko.getString("suoritus_pvm"));
            }
        } catch (SQLException se) {
            throw se;
        }
        return opintosuoritus;
    }

    /*
    Lisätään opintosuorituksen tiedot tietokantaan. Parametrina tietokantayhteys.
     */

    public int lisaaOpintosuoritus(Connection connection) throws SQLException, Exception {
        // Haetaan tietokannasta opintosuoritusta, jonka id:t vastaavat olion id:eitä. Jos id:t ovat jo kannassa, oliota ei lisätä.
        String sql = "SELECT opiskelija_id, kurssi_id" + " FROM opintosuoritus WHERE opiskelija_id = ? AND kurssi_id = ?"; // WHERE-ehto toteutetaan taas myöhemmin
        // Suoritetaan SQL-lause
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getOpiskelija_id()); // WHERE-ehdon arvo
            lause.setInt(2, getKurssi_id()); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            if (tulosjoukko.next()) {
                throw new Exception("Tunnuksia " + getOpiskelija_id() + " ja " + getKurssi_id() + " vastaava opintosuoritus on jo tallennettu jarjestelmaan.");
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
        sql = "INSERT INTO opintosuoritus (opiskelija_id, kurssi_id, arvosana, suoritus_pvm)" + "VALUES (?, ?, ?, ?)";

        System.out.println("Ajetaan SQL-lause muodossa " + sql);

        lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getOpiskelija_id());
            lause.setInt(2, getKurssi_id());
            lause.setInt(3, getArvosana());
            lause.setString(4, getSuoritus_pvm());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Opintosuorituksen lisaaminen ei onnistu. \n");
            } else {
                throw new Exception("Opintosuorituksen lisaaminen onnistui. \n");
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
    Muutetaan opintosuorituksen tietoja tunnusta (id) lukuunottamatta.
     */

    public int muutaOpintosuoritus(Connection connection) throws SQLException, Exception {
        // Haetaan tietokannasta opintosuoritusta, jossa kurssi_id = opintosuoritusolion id
        String sql = "SELECT opiskelija_id, kurssi_id"
                + " FROM opintosuoritus WHERE opiskelija_id = ? AND kurssi_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, getOpiskelija_id()); // WHERE-ehdon arvo
            lause.setInt(2, getKurssi_id());

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos opintosuoritusta ei löydy
            if (!tulosjoukko.next()) {
                throw new Exception("Opiskelijan tunnusta " + getOpiskelija_id() + " ja kurssin tunnusta " + getKurssi_id() + " vastaava opintosuoritus ei ole tietokannassa.");
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
        sql = "UPDATE opintosuoritus "
                + "SET arvosana = ?, suoritus_pvm = ?"
                + " WHERE opiskelija_id = ? AND kurssi_id = ?";

        System.out.println("Syotetaan annetut tiedot lauseella " + sql);

        lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);

            lause.setInt(1, getArvosana());
            lause.setString(2, getSuoritus_pvm());
            lause.setInt(3, getOpiskelija_id());
            lause.setInt(4, getKurssi_id());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();

            if (lukumaara == 0) {
                throw new Exception("Opiskelijan tunnusta " + getOpiskelija_id() + " ja kurssin tunnusta " + getKurssi_id() + " vastaavaa opintosuoritusta ei loydy. \n");
            } else {
                throw new Exception("Opiskelijan tunnusta " + getOpiskelija_id() + " ja kurssin tunnusta " + getKurssi_id() + " vastaavan opintosuorituksen tietojen muuttaminen onnistui. \n");
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

    public int poistaOpintosuoritus(Connection connection) throws SQLException, Exception {

        // Kootaan DELETE-lause, jolla opintosuoritus poistetaan tietokannasta.
        String sql = "DELETE FROM opintosuoritus WHERE opiskelija_id = ? AND kurssi_id = ?";
        PreparedStatement lause = null;

        try {
            // Luodaan PreparedStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);

            // Sijoitetaan arvo WHERE-ehdolle
            lause.setInt(1, getOpiskelija_id());
            lause.setInt(2, getKurssi_id());

            // Suoritetaan SQL-lause
            int lukumaara = lause.executeUpdate();
            if (lukumaara == 0) {
                throw new Exception("Opiskelijan tunnusta " + getOpiskelija_id() + " ja kurssin tunnusta " + getKurssi_id() + " vastaavaa opintosuoritusta ei loydy. \n");
            } else {
                System.out.println("Opiskelijan tunnusta " + getOpiskelija_id() + " ja kurssin tunnusta " + getKurssi_id() + " vastaavan opintosuorituksen poistaminen onnistui. \n");
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

    public Opintosuoritus haeOpiskelijanSuoritukset(Connection connection, int opiskelija_id, Opintosuoritus opintosuoritus) throws SQLException, Exception {
        // Haetaan opintosuoritus-taulusta opiskelijaa ID:n perusteella
        String sql = "SELECT * FROM opintosuoritus WHERE opiskelija_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PrepareStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, opiskelija_id); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos opintosuorituksia ei löydy ID:llä
            if (!tulosjoukko.isBeforeFirst()) {
                throw new Exception("Opintosuorituksia ei loytynyt opiskelijatunnuksen " + opiskelija_id + " perusteella. \n");
            }
        } catch (Exception e) {
            throw e;
        }
        /*
        Käsitellään saatu tulosjoukko, ja sijoitetaan tiedot opintosuoritusolioon.
         */
        try {
            while (tulosjoukko.next()) {
                opintosuoritus.setOpiskelija_id(tulosjoukko.getInt("opiskelija_id"));
                opintosuoritus.setKurssi_id(tulosjoukko.getInt("kurssi_id"));
                opintosuoritus.setArvosana(tulosjoukko.getInt("arvosana"));
                opintosuoritus.setSuoritus_pvm(tulosjoukko.getString("suoritus_pvm"));
                System.out.println(opintosuoritus.toString() + "\n");
            }
        } catch (SQLException se) {
            throw se;
        }
        return opintosuoritus;
    }

    public Opintosuoritus haeKurssinSuoritukset(Connection connection, int kurssi_id, Opintosuoritus opintosuoritus) throws SQLException, Exception {
        // Haetaan opintosuoritus-taulusta kurssia ID:n perusteella
        String sql = "SELECT * FROM opintosuoritus WHERE kurssi_id = ?";
        ResultSet tulosjoukko = null;
        PreparedStatement lause = null;

        try {
            // Luodaan PrepareStatement-olio SQL-lauseelle
            lause = connection.prepareStatement(sql);
            lause.setInt(1, kurssi_id); // WHERE-ehdon arvo

            // Suoritetaan SQL-lause
            tulosjoukko = lause.executeQuery();

            // Jos opintosuorituksia ei löydy ID:llä
            if (!tulosjoukko.isBeforeFirst()) {
                throw new Exception("Opintosuorituksia ei loytynyt kurssitunnuksen " + kurssi_id + " perusteella. \n");
            }
        } catch (Exception e) {
            throw e;
        }
        /*
        Käsitellään saatu tulosjoukko, ja sijoitetaan tiedot opintosuoritusolioon.
         */
        try {
            while (tulosjoukko.next()) {
                opintosuoritus.setOpiskelija_id(tulosjoukko.getInt("opiskelija_id"));
                opintosuoritus.setKurssi_id(tulosjoukko.getInt("kurssi_id"));
                opintosuoritus.setArvosana(tulosjoukko.getInt("arvosana"));
                opintosuoritus.setSuoritus_pvm(tulosjoukko.getString("suoritus_pvm"));
                System.out.println(opintosuoritus.toString() + "\n");;
            }
        } catch (SQLException se) {
            throw se;
        }
        return opintosuoritus;
    }
}



