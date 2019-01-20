/**
 * Juuso Uusimäki, 18.1.2019, Ohjelmointi III - Harjoitustehtävät 5.
 *
 * 2. Laadi metodi, joka ottaa parametrinaan alueen leveyden ja pituuden metreinä,
 * sekä tiedon siitä palautetaanko tulos aareina tai hehtaareina.
 * Tämän jälkeen metodi laskee alueen alan ja palauttaa tuloksen.
 *
 * Laadi myös pääohjelma, jonka avulla testaat metodia.
 */

package harjoitustehtavat5;

import java.util.*;

public class PintaAla {

    public static void main(String[] args) {

        Scanner lukija;
        lukija = new Scanner(System.in);

        // Luodaan tarvittavat muuttujat ja taulukko palautuksen vastaanottoa varten
        float leveys, pituus;
        byte formaatti;
        float[] palautus = new float[2];

        // Kysytään ja luetaan tiedot
        System.out.println("Syota alueen leveys metreina: ");
        leveys = lukija.nextInt();

        System.out.println("Syota alueen pituus metreina: ");
        pituus = lukija.nextInt();

        System.out.println("Palautetaanko tulos aareina (syota 1) vai hehtaareina (syota 2): ");
        formaatti = lukija.nextByte();

        // Suoritetaan metodi, joka laskee pinta-alan palauttaa taulukon
        palautus = pintaAlalaskuri(leveys, pituus, formaatti);

        // Ajetaan formaattivalinnan mukaan. Jos ensimmäinen taulukon arvo poikkeaa nollasta, on valittu formaatti 1 eli aari.
        if (palautus[0] != 0) {
            System.out.println("Alueen pinta-ala aareina on " + palautus[0] + ".");
        }

        else if (palautus[1] != 0) {
            System.out.println("Alueen pinta-ala hehtaareina on " + palautus[1] + ".");
        }

        else {
            System.out.println("Virhe ohjelman suorituksessa!");
        }

    }

    // Metodi, jota pääohjelmalla ajetaan
    public static float[] pintaAlalaskuri(float leveys, float pituus, byte formaatti) {

        // Luodaan tarvittavat muuttujat ja taulukko palautusta varten
        float pintaAla = 0;
        float alaAari = 0;
        float alaHehtaari = 0;
        float[] tulos = new float[2];
        tulos[0] = 0;
        tulos[1] = 0;

        // Lasketaan pinta-ala argumenttien avulla
        pintaAla = leveys * pituus;

        // Valitaan tapahtuma argumentin avulla ja muutetaan tulos aareihin
        if (formaatti == 1) {
            alaAari = pintaAla / 100;
            tulos[0] = alaAari;
        }

        // Valitaan tapahtuma argumentin avulla ja muutetaan tulos hehtaareihin
        else if (formaatti == 2) {
            alaHehtaari = pintaAla / 10000;
            tulos[1] = alaHehtaari;
        }

        else {
            System.out.println("Palautuksen valinta ei kelpaa!");
        }
        // Palautetaan tulokset taulukkona pääohjelmalle
        return tulos;
    }
}
