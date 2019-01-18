/**
 *
 * Juuso Uusimäki, 15.1.2019, Ohjelmointi III - Harjoitustehtävät 4.
 *
 * 1. Laadi ohjelma, joka laskee ympyrän pinta-alan tai pallon tilavuuden.
 * Ohjelman tulee kysyä ensin käyttäjältä, onko kyse pallosta vai ympyrästä.
 * Tämän jälkeen ohjelman tulee kysyä käyttäjältä ympyrän tai pallon säde
 * ja laskea sen perusteella pinta-ala tai tilavuus.
 * Lopuksi Ohjelman tulee tulostaa pinta-ala tai tilavuus näytölle.
 *
 */

import java.util.*;


public class Tilavuuslaskuri {

    public static void main(String[] args) {
        Scanner lukija;
        lukija = new Scanner(System.in);

        System.out.println("Ohjelman kayttoohjeet: Ohjelma pyytaa kayttajaa valitsemaan pallon tai ympyran, " +
                "ja syottamaan vastaavan sateen. \nTaman jalkeen ohjelma laskee sateen avulla joko pallon tilavuuden " +
                "tai ympyran pinta-alan.");

        byte valinta = 0; // Valitaan sopivat tietotyypit
        int sade = 0;
        double pintaAla = 0; // Pii vaatii doublen
        double tilavuus = 0;

        try {

            // Kysytään käyttäjältä kumman haluaa valita, ja luetaan vastaus muuttujaan
            System.out.println("Jos haluat valita pallon, syota 1. Jos haluat valita ympyran, syota 2: ");
            valinta = lukija.nextByte();

            if (valinta == 1) { // Jos valittu pallo (1)

                // Kysytään käyttäjältä pallon sädettä, ja luetaan vastaus muuttujaan
                System.out.println("Syota pallon sade (cm): ");
                sade = lukija.nextInt();

                // Lasketaan pallon tilavuus piin (Math.PI-metodi) ja säteen avulla (potenssissa Math.pow-metodi)
                tilavuus = (4 / 3) * Math.PI * (Math.pow(sade, 3));
                System.out.println("Pallon tilavuus on "); // Ilmoitetaan tuloksesta
                System.out.printf("%.2f", tilavuus); // Pyöristetään kahden desimaalin tarkkuuteen
                System.out.println(" cm^3.");
            }

            else if (valinta == 2) { // Jos valittu ympyrä (2), toimitaan samoin pinta-alan laskussa
                System.out.println("Syota ympyran sade (cm): ");
                sade = lukija.nextInt();
                pintaAla = Math.PI*(Math.pow(sade,2));
                System.out.println("Ympyran pinta-ala on ");
                System.out.printf("%.2f", pintaAla);
                System.out.println(" cm^2.");
            }

            else { // Jos syötetty jokin muu luku kuin 1 tai 2
                System.out.println("Syotetty vaara luku. Ohjelma sulkeutuu.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Virhe syotossa! Ohjelma sulkeutuu.");
        }
    }
}
