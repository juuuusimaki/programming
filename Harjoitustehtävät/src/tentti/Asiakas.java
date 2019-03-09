/**
 * Juuso Uusimäki, 3.3.2019, Ohjelmointi III - Tentti
 *
 * 1. Kirjoita luokka Asiakas, joka toteuttaa Javan Comparable-rajapinnan. Määrittely on:
 * Asiakas (selvitä alla nimetyistä metodeista tarvittavat tiedot luokan attribuuteille).
 * + Asiakas(nimi: String, tunnus: int, osoite:String)
 * + lisaaOstosSummaan(ostos : double)
 * + getOstosSumma(): double
 * + toString(): String
 * Asiakas-olioita verrataan toisiinsa ostosten summan perusteella.
 *
 */


package tentti;

import static java.lang.Double.compare;

public class Asiakas implements Comparable<Asiakas> {

    // Attribuutit - luodaan tehtävänannon vaatimat attribuutit oikeat datatyypit huomioiden
    protected String nimi;
    protected int tunnus;
    protected String osoite;
    protected double ostosSumma;

    // Konstruktori - luodaan Asiakas-luokan konstruktori. OstosSumma-attribuutin alkuarvo on 0.
    Asiakas(String nimi, int tunnus, String osoite) {
        this.nimi = nimi;
        this.tunnus = tunnus;
        this.osoite = osoite;
        this.ostosSumma = 0;
    }

    // KantaAsiakas-luokka vaatii oletuskonstruktorin
    Asiakas() {

    }

    // Metodit

    // OstosSummaan lisääminen
    public void lisaaOstosSummaan(double ostos) {
        ostosSumma = ostosSumma + ostos;
    }

    // OstosSumman palauttaminen
    public double getOstosSumma() {
        return ostosSumma;
    }

    // compareTo-metodi vertailua varten.
    @Override
    public int compareTo(Asiakas other) {
        return compare(this.ostosSumma, other.ostosSumma);
    }

    // toString-metodi
    @Override
    public String toString() {
        return "Asiakas{" +
                "nimi='" + nimi + '\'' +
                ", tunnus=" + tunnus +
                ", osoite='" + osoite + '\'' +
                ", ostosSumma=" + ostosSumma +
                '}';
    }
}
