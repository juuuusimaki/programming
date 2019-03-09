/**
 *
 * Opiskelijoiden kurssisuoritusten hallintasovellus, jossa käyttöliittymänä voi olla merkkipohjainen käyttöliittymä tai
 * GUI. Sovelluksen avulla on mahdollista ylläpitää opiskelijan ja kurssien perustietoja sekä opiskelijan
 * suoritustietoja. Opiskelijoiden, kurssien ja suoritusten tiedot tallennetaan tietokantaan. Opiskelijoiden,
 * kurssien ja suoritusten tietoja tulee voida muokata, lisätä sekä poistaa.
 * Toteutus tehdään olio-ohjelmoinnin periaatteita noudattaen.
 *
 */

package lopputyo;

import java.sql.*;
import java.lang.*;
import java.util.Scanner;


// javac -cp "mariadb-java-client-2.2.3.jar;." lopputyo\*.java
// java -cp "mariadb-java-client-2.2.3.jar;." lopputyo.Kayttoliittyma


public class Kayttoliittyma {

    public static void main(String[] args) throws Exception {


        // Yhdistys SQL-tietokantaan
        System.out.println("Yhdistetaan Opsuor...");
        // määritellään yhteysolio tietokantayhteyttä varten
        Connection connection = null;
        try {
            // yhdistä-funktio luo yhteyden ja palauttaa sen paluuarvona
            connection = yhdista();
        } catch (
                SQLException se) {
            // SQL virheet
            se.printStackTrace();
        } catch (Exception e) {
            // JDBC virheet
            e.printStackTrace();
        }

        // while-loop, joka pitää ohjelman käynnissä
        int numero = 1;

        while (numero != 0) {

            System.out.println("\n");
            System.out.println("** Opiskelijoiden kurssisuoritusten hallintaohjelma. **\n" +
                    "Ohjelmaa ajetaan numerovalikolla. \n" +
                    "1 = Opiskelijoiden tiedot \n" +
                    "2 = Kurssien tiedot \n" +
                    "3 = Suoritusten tiedot \n" +
                    "0 = Ohjelman lopettaminen \n");

            // Luodaan lukija, joka käsittelee syöttöjä
            Scanner lukija = new Scanner(System.in);
            System.out.println("Syota haluamaasi toimintoa vastaava numero: ");
            int t = lukija.nextInt();
            System.out.println("\n");

            // **1 = Opiskelijoiden tiedot**
            while (t == 1) {
                System.out.println("** Valikko 1: Opiskelijan tiedot **\n" +
                        "Valitse haluamasi toiminto: \n" +
                        "1 = Opiskelijan tietojen hakeminen ID:n perusteella \n" +
                        "2 = Opiskelijan lisaaminen \n" +
                        "3 = Opiskelijan tietojen muuttaminen \n" +
                        "4 = Opiskelijan poistaminen ID:n perusteella \n" +
                        "-1 = Ylempaan valikkoon palaaminen \n");

                // Kysytaan haluttu toiminto, ja toimitaan sen mukaan
                System.out.println("Syota haluamaasi toimintoa vastaava numero: ");
                int o = lukija.nextInt();

                if (o == -1) {
                    t = o;
                }

                while (o == 1 || o == 2 || o == 3 || o == 4) {
                    if (o == 1) {
                        Opiskelija opiskelija = new Opiskelija();
                        System.out.println("** Valikko 1.1: Opiskelijan tietojen hakeminen ID:n perusteella. **\n" +
                                "Syota haettava ID: ");
                        int ID = lukija.nextInt();

                        // Haetaan opiskelijan tiedot, ja tulostetaan ne näytölle
                        if (ID != -1) {
                            try {
                                opiskelija.haeOpiskelija(connection, ID, opiskelija);
                                System.out.println(opiskelija.toString() + "\n");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            o = ID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }

                    if (o == 2) {
                        Opiskelija opiskelija = new Opiskelija();
                        System.out.println("** Valikko 1.2: Opiskelijan lisaaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("ID: ");
                        int ID = lukija.nextInt();
                        opiskelija.setOpiskelija_id(ID);
                        if (ID != -1) {
                            try {
                                System.out.println("Etunimi: ");
                                lukija.nextLine();
                                String enimi = lukija.nextLine();
                                opiskelija.setEtunimi(enimi);
                                System.out.println("Sukunimi: ");
                                String snimi = lukija.nextLine();
                                opiskelija.setSukunimi(snimi);
                                System.out.println("Lahiosoite: ");
                                String lahiosoite = lukija.nextLine();
                                opiskelija.setLahiosoite(lahiosoite);
                                System.out.println("Postitoimipaikka ");
                                String postitoimipaikka = lukija.nextLine();
                                opiskelija.setPostitoimipaikka(postitoimipaikka);
                                System.out.println("Postinumero: ");
                                String postinumero = lukija.nextLine();
                                opiskelija.setPostinumero(postinumero);
                                System.out.println("Sahkoposti: ");
                                String sahkoposti = lukija.nextLine();
                                opiskelija.setSahkoposti(sahkoposti);
                                System.out.println("Puhelinnumero: ");
                                String puhelinnumero = lukija.nextLine();
                                opiskelija.setPuhelinnumero(puhelinnumero);
                                opiskelija.lisaaOpiskelija(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            o = ID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }

                        //} catch (Exception e) {
                        //System.out.println(e.getMessage());
                        //}
                    }

                    if (o == 3) {
                        Opiskelija opiskelija = new Opiskelija();
                        System.out.println("** Valikko 1.3: Opiskelijan tietojen muuttaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("Haettava ID: ");
                        int ID = lukija.nextInt();
                        opiskelija.setOpiskelija_id(ID);
                        if (ID != -1) {
                            try {
                                System.out.println("Uusi etunimi: ");
                                lukija.nextLine();
                                String enimi = lukija.nextLine();
                                opiskelija.setEtunimi(enimi);
                                System.out.println("Uusi sukunimi: ");
                                String snimi = lukija.nextLine();
                                opiskelija.setSukunimi(snimi);
                                System.out.println("Uusi lahiosoite: ");
                                String lahiosoite = lukija.nextLine();
                                opiskelija.setLahiosoite(lahiosoite);
                                System.out.println("Uusi postitoimipaikka ");
                                String postitoimipaikka = lukija.nextLine();
                                opiskelija.setPostitoimipaikka(postitoimipaikka);
                                System.out.println("Uusi postinumero: ");
                                String postinumero = lukija.nextLine();
                                opiskelija.setPostinumero(postinumero);
                                System.out.println("Uusi sahkoposti: ");
                                String sahkoposti = lukija.nextLine();
                                opiskelija.setSahkoposti(sahkoposti);
                                System.out.println("Uusi puhelinnumero: ");
                                String puhelinnumero = lukija.nextLine();
                                opiskelija.setPuhelinnumero(puhelinnumero);
                                opiskelija.muutaOpiskelija(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            o = ID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }

                    // Opiskelijan poistaminen ID:n perusteella
                    if (o == 4) {
                        Opiskelija opiskelija = new Opiskelija();
                        System.out.println("** Valikko 1.4: Opiskelijan poistaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("Poistettavan opiskelijan ID: ");
                        int ID = lukija.nextInt();
                        opiskelija.setOpiskelija_id(ID);
                        if (ID != -1) {
                            try {
                                // Poistetaan tunnustava vastaava opiskelija
                                opiskelija.poistaOpiskelija(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            o = ID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }
                }
            }

            // **2 = Kurssien tiedot**
            while (t == 2) {
                System.out.println("** Valikko 2: Kurssin tiedot **\n" +
                        "Valitse haluamasi toiminto: \n" +
                        "1 = Kurssin tietojen hakeminen ID:n perusteella \n" +
                        "2 = Kurssin lisaaminen \n" +
                        "3 = Kurssin tietojen muuttaminen \n" +
                        "4 = Kurssin poistaminen ID:n perusteella \n" +
                        "-1 = Ylempaan valikkoon palaaminen \n");

                // Kysytaan haluttu toiminto, ja toimitaan sen mukaan
                System.out.println("Syota haluamaasi toimintoa vastaava numero: ");
                int k = lukija.nextInt();

                if (k == -1) {
                    t = k;
                }

                while (k == 1 || k == 2 || k == 3 || k == 4) {

                    // Kurssin hakeminen
                    if (k == 1) {
                        Kurssi kurssi = new Kurssi();
                        System.out.println("** Valikko 2.1: Kurssin tietojen hakeminen ID:n perusteella. **\n" +
                                "Syota haettava ID: ");
                        int ID = lukija.nextInt();

                        // Haetaan kurssin tiedot, ja tulostetaan ne näytölle
                        if (ID != -1) {
                            try {
                                kurssi.haeKurssi(connection, ID, kurssi);
                                System.out.println(kurssi.toString() + "\n");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            k = ID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }

                    if (k == 2) {
                        Kurssi kurssi = new Kurssi();
                        System.out.println("** Valikko  2.2: Kurssin lisaaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("ID: ");
                        int ID = lukija.nextInt();
                        kurssi.setKurssi_id(ID);
                        if (ID != -1) {
                            try {
                                System.out.println("Nimi: ");
                                lukija.nextLine();
                                String nimi = lukija.nextLine();
                                kurssi.setNimi(nimi);
                                System.out.println("Opintopisteet: ");
                                int opintopisteet = lukija.nextInt();
                                kurssi.setOpintopisteet(opintopisteet);
                                lukija.nextLine();
                                System.out.println("Kuvaus: ");
                                String kuvaus = lukija.nextLine();
                                kurssi.setKuvaus(kuvaus);
                                kurssi.lisaaKurssi(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            k = ID;
                            System.out.println("Palataan ylempaan valikkoon.  \n");
                        }
                    }

                    if (k == 3) {
                        Kurssi kurssi = new Kurssi();
                        System.out.println("** Valikko 2.3: Kurssin tietojen muuttaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("Haettava ID: ");
                        int ID = lukija.nextInt();
                        kurssi.setKurssi_id(ID);
                        if (ID != -1) {
                            try {
                                System.out.println("Uusi nimi: ");
                                lukija.nextLine();
                                String nimi = lukija.nextLine();
                                kurssi.setNimi(nimi);
                                System.out.println("Uusi opintopisteiden maara: ");
                                int opintopisteet = lukija.nextInt();
                                kurssi.setOpintopisteet(opintopisteet);
                                lukija.nextLine();
                                System.out.println("Uusi kuvaus: ");
                                String kuvaus = lukija.nextLine();
                                kurssi.setKuvaus(kuvaus);
                                kurssi.muutaKurssi(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            k = ID;
                            System.out.println("Palataan ylempaan valikkoon.  \n");
                        }
                    }
                    // Kurssin poistaminen ID:n perusteella
                    if (k == 4) {
                        Kurssi kurssi = new Kurssi();
                        System.out.println("** Valikko 2.4: Kurssin poistaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("Poistettavan kurssin ID: ");
                        int ID = lukija.nextInt();
                        kurssi.setKurssi_id(ID);
                        if (ID != -1) {
                            try {
                                // Poistetaan tunnustava vastaava kurssi
                                kurssi.poistaKurssi(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            k = ID;
                            System.out.println("Palataan ylempaan valikkoon.  \n");
                        }
                    }
                }
        }

        // **3 = Opintosuoritusten tiedot**
        while (t == 3) {
            System.out.println("** Valikko 3: Opintosuoritusten tiedot **\n" +
                    "Valitse haluamasi toiminto: \n" +
                    "1 = Opintosuorituksen tietojen hakeminen ID:n perusteella \n" +
                    "2 = Opintosuorituksen lisaaminen \n" +
                    "3 = Opintosuorituksen tietojen muuttaminen \n" +
                    "4 = Opintosuorituksen poistaminen ID:n perusteella \n" +
                    "5 = Opiskelijan opintosuoritusten listaaminen ID:n perusteella \n" +
                    "6 = Kurssin opintosuoritusten listaaminen ID:n perusteella \n" +
                    "-1 = Ylempaan valikkoon palaaminen \n");

            // Kysytaan haluttu toiminto, ja toimitaan sen mukaan
            System.out.println("Syota haluamaasi toimintoa vastaava numero: ");
            int s = lukija.nextInt();
            if (s == -1) {
                t = s;
            }

            while (s == 1 || s == 2 || s == 3 || s == 4 || s == 5 || s == 6) {
                    // Opintosuorituksen hakeminen
                    if (s == 1) {
                        Opintosuoritus opintosuoritus = new Opintosuoritus();
                        System.out.println("** Valikko 3.1: Opintosuorituksen tietojen hakeminen ID:n perusteella. **\n" +
                                "Syota haettavan opiskelijan ID: ");
                        int oID = lukija.nextInt();
                        // Haetaan opintosuorituksen tiedot
                        if (oID != -1) {
                            try {
                                System.out.println("Syota haettavan kurssin ID: ");
                                int kID = lukija.nextInt();
                                opintosuoritus.haeOpintosuoritus(connection, oID, kID, opintosuoritus);
                                System.out.println(opintosuoritus.toString() + "\n");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            s = oID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }
                    // Opintosuorituksen lisaaminen
                    if (s == 2) {
                        Opintosuoritus opintosuoritus = new Opintosuoritus();
                        System.out.println("** Valikko  3.2: Opintosuorituksen lisaaminen. **\n" +
                                "Syota tiedot:\n" +
                                "Syota opiskelijan ID:");
                        int oID = lukija.nextInt();
                        opintosuoritus.setOpiskelija_id(oID);
                        if (oID != -1) {
                            try {
                                System.out.println("Kurssin ID: ");
                                int kID = lukija.nextInt();
                                opintosuoritus.setKurssi_id(kID);
                                System.out.println("Arvosana: ");
                                lukija.nextLine();
                                int arvosana = lukija.nextInt();
                                opintosuoritus.setArvosana(arvosana);
                                System.out.println("Suorituspaivamaara (muodossa VVVV-KK-PP): ");
                                String muokattu_pvm = lukija.next();
                                opintosuoritus.setSuoritus_pvm(muokattu_pvm);
                                lukija.nextLine();
                                opintosuoritus.lisaaOpintosuoritus(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            s = oID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }
                    if (s == 3) {
                        Opintosuoritus opintosuoritus = new Opintosuoritus();
                        System.out.println("** Valikko 3.3: Opintosuorituksen tietojen muuttaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("Haettava opiskelijan ID: ");
                        int oID = lukija.nextInt();
                        opintosuoritus.setOpiskelija_id(oID);
                        if (oID != -1) {
                            try {
                                System.out.println("Haettava kurssin ID: ");
                                int kID = lukija.nextInt();
                                opintosuoritus.setKurssi_id(kID);
                                System.out.println("Syota uusi arvosana: ");
                                lukija.nextLine();
                                int arvosana = lukija.nextInt();
                                opintosuoritus.setArvosana(arvosana);
                                System.out.println("Syota uusi suorituspaivamaara (muodossa VVVV-KK-PP): ");
                                String suoritus_pvm = lukija.next();
                                opintosuoritus.setSuoritus_pvm(suoritus_pvm);
                                lukija.nextLine();
                                opintosuoritus.muutaOpintosuoritus(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            s = oID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }

                    // Opintosuorituksen poistaminen
                    if (s == 4) {
                        Opintosuoritus opintosuoritus = new Opintosuoritus();
                        System.out.println("** Valikko 3.4: Kurssin poistaminen. **\n" +
                                "Syota tiedot:");
                        System.out.println("Haettavan opiskelijan ID: ");
                        int oID = lukija.nextInt();
                        opintosuoritus.setOpiskelija_id(oID);
                        if (oID != -1) {
                            try {
                                System.out.println("Haettavan kurssin ID: ");
                                int kID = lukija.nextInt();
                                opintosuoritus.setKurssi_id(kID);
                                // Poistetaan tunnuksia vastaava opintosuoritus
                                opintosuoritus.poistaOpintosuoritus(connection);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            s = oID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }

                    if (s == 5) {
                        Opintosuoritus opintosuoritus = new Opintosuoritus();
                        System.out.println("** Valikko 3.5: Opiskelijan opintosuoritusten hakeminen ID:n perusteella. **\n" +
                                "Syota haettavan opiskelijan ID: ");
                        int oID = lukija.nextInt();
                        // Haetaan opintosuorituksen tiedot
                        if (oID != -1) {
                            try {
                                opintosuoritus.haeOpiskelijanSuoritukset(connection, oID, opintosuoritus);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            s = oID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }

                    // Kurssin opintosuoritusten listaaminen ID:n perusteella
                    if (s == 6) {
                        Opintosuoritus opintosuoritus = new Opintosuoritus();
                        System.out.println("** Valikko 3.6: Kurssin opintosuoritusten hakeminen ID:n perusteella. **\n" +
                                "Syota haettavan kurssin ID: ");
                        int kID = lukija.nextInt();
                        // Haetaan opintosuorituksen tiedot
                        if (kID != -1) {
                            try {
                                opintosuoritus.haeKurssinSuoritukset(connection, kID, opintosuoritus);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            s = kID;
                            System.out.println("Palataan ylempaan valikkoon. \n");
                        }
                    }
            }
        }

        // **-1 = Lopetus**
        if (t == 0) {
            numero = t;
            System.out.println("0 syotetty. Ohjelma sulkeutuu.");
        }
    }

}

    // Tietokantaan yhdistys
    public static Connection yhdista() throws SQLException, Exception {
        Connection connection = null;
        String url = "jdbc:mariadb://localhost:3306/opsuor"; // palvelin = localhost, :portti annettu asennettaessa, tietokannan nimi
        try {
            // ota yhteys kantaan, kayttaja = root, salasana = root
            connection = DriverManager.getConnection(url, "root", "aaaa");
        } catch (SQLException se) { // tietokantaan ei saada yhteyttä
            //connection = null;
            throw se;
        } catch (Exception e) { // JDBC ajuria ei löydy
            throw e;

        }
        return connection; // palautetaan tietokantayhteys
    }
}
