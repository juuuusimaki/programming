/**
 * Juuso Uusimäki, 18.1.2019, Ohjelmointi III - Harjoitustehtävät 5.
 *
 * 1. Laadi metodi (eli funktio), joka ottaa parametrinaan vuoden, kuukauden,
 * päivän ja tulostusformaatin. Metodi tulostaa päivänmäärän halutussa formaatissa.
 * Alla on mahdolliset formaattivaihtoehdot:
 *
 * 6. joulukuuta 1917 (normaali formaatti)
 * 6.12.1917 (lyhyt formaatti esimerkiksi taulukoihin)
 * 1917-12-06 (kansainvälinen formaatti)
 *
 * Laadi myös pääohjelma, jossa kutsutaan kyseistä metodia.
 *
 */

package harjoitustehtavat5;

import java.util.*;

public class Paivamaara {

    // Pääohjelma
    public static void main(String[] args) {

        Scanner lukija;
        lukija = new Scanner(System.in);

        // Luodaan muuttujat
        short vuosi, kuukausi, pvm;
        byte formaatti;

        System.out.println("Syota vuosi, kuukausi ja paivamaara, seka valitse haluamasi formaatti (1-3): ");
        // Kysytään tietoja ja luetaan ne muuttujiin
        System.out.println("Syota vuosi: ");
        vuosi = lukija.nextShort();

        System.out.println("Syota kuukausi: ");
        kuukausi = lukija.nextShort();

        System.out.println("Syota paivamaara: ");
        pvm = lukija.nextShort();

        System.out.println("Syota formaatti: ");
        formaatti = lukija.nextByte();

        // Kutsutaan haluttua metodia
        paivamaaraFormaatiksi(vuosi, kuukausi, pvm, formaatti);
    }


    public static void paivamaaraFormaatiksi(short vuosi, short kuukausi, short pvm, short formaatti) {

        // Luodaan kuukausitaulukko
        String[] kuukaudet = new String[12];
        kuukaudet[0] = "tammikuu";
        kuukaudet[1] = "helmikuu";
        kuukaudet[2] = "maaliskuu";
        kuukaudet[3] = "huhtikuu";
        kuukaudet[4] = "toukokuu";
        kuukaudet[5] = "kesakuu";
        kuukaudet[6] = "heinakuu";
        kuukaudet[7] = "elokuu";
        kuukaudet[8] = "syyskuu";
        kuukaudet[9] = "lokakuu";
        kuukaudet[10] = "marraskuu";
        kuukaudet[11] = "joulukuu";

        // Valitaan toiminta formaatin mukaan
        if (formaatti == 1) {
            System.out.println(pvm + " " + kuukaudet[kuukausi-1] + "ta " + vuosi);
        }

        else if (formaatti == 2) {
            System.out.println(pvm + "." + kuukausi + "." + vuosi);
        }

        else if (formaatti == 3) {
            System.out.println(vuosi + "-" + kuukausi + "-" + pvm);
        }

        else {
            System.out.println("Valitsemasi formaatti ei kelpaa!");
        }
    }
}
