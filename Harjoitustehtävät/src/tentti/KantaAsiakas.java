/**
 * Juuso Uusimäki, 3.3.2019, Ohjelmointi III - Tentti
 *
 * 2. Toteuta luokka KantaAsiakas, joka periytyy Asiakas-luokasta.
 * Kanta-asiakkaalla on edellisten tietojen lisäksi sähköpostiosoite ja syntymävuosi.
 * Toteuta KantaAsiakas -luokkaan konstruktori ja metodit sahköpostiosoitteen
 * ja syntymävuoden palauttamiseen sekä toString() metodi.
 *
*/

package tentti;

public class KantaAsiakas extends Asiakas {

    // Attribuutit
    private String sahkoposti;
    private int vuosi;

    // Konstruktori
    KantaAsiakas(String nimi, int tunnus, String osoite,  int vuosi, String sahkoposti) {
        super(nimi, tunnus, osoite);
        this.sahkoposti = sahkoposti;
        this.vuosi = vuosi;
    }

    // Metodit

    public String getSahkoposti() {
        return sahkoposti;
    }

    public int getVuosi() {
        return vuosi;
    }

    // toString-metodi
    @Override
    public String toString() {
        return "KantaAsiakas{" +
                "sahkoposti='" + sahkoposti + '\'' +
                ", vuosi=" + vuosi +
                ", nimi='" + nimi + '\'' +
                ", tunnus=" + tunnus +
                ", osoite='" + osoite + '\'' +
                ", ostosSumma=" + ostosSumma +
                '}';
    }
}
