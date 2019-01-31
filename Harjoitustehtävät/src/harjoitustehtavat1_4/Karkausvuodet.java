package harjoitustehtavat1_4; /**
 * Juuso Uusimäki, 15.1.2019, Ohjelmointi III - Harjoitustehtävät 4.
 * <p>
 * 3. Laadi ohjelma, joka kyselee käyttäjältä vuosilukuja, kunnes käyttäjä syöttää luvun -1.
 * Vuosiluvun perusteella ohjelma tulostaa kyseisen vuoden jokaisen kuukauden päivien lukumäärän.
 * Laadi ohjelma siten, että se osaa huomioida karkausvuoden.
 */

import java.util.*;

public class Karkausvuodet {
    public static void main(String[] args) {
        Scanner lukija;
        lukija = new Scanner(System.in);

        int vuosiLuku = 0; // Luodaan ja alustetaan muuttuja

        try {

            System.out.println("Ohjelmaan syotetaan vuosilukuja, ja ohjelma tarkistaa, onko kyseessa karkausvuosi. \n" +
                    "Taman jalkeen ohjelma tulostaa valitun vuoden jokaisen kuukauden paivien lukumaaran. \n" +
                    "Ohjelmasta voi poistua syottamalla luvun -1.");

            // Suoritetaan kunnes syötetään
            while (vuosiLuku != -1) {

                // Pyydetään lukijalta vuosiluku, ja luetaan se muuttujaan
                System.out.println("Syota vuosiluku: ");
                vuosiLuku = lukija.nextInt();

                // Jos syötetty -1, ohjelma suljetaan
                if (vuosiLuku == -1) {
                    System.out.println("Ohjelma suljetaan.");
                    break;
                }

                // Jos valittu vuosiluku on neljällä jaollinen mutta ei sadalla, tai neljällä ja neljälläsadalla.
                else if ((vuosiLuku % 4 == 0 && vuosiLuku % 100 != 0) || (vuosiLuku % 4 == 0 && vuosiLuku % 400 == 0)) {
                    System.out.println("Vuosi " + vuosiLuku + " on karkausvuosi, ja sen \n" +
                            "tammikuussa on 31 paivaa,\n" +
                            "helmikuussa on 29 paivaa,\n" + // Huomioitu karkausvuoden yksi ylimääräinen päivä
                            "maaliskuussa on 31 paivaa,\n" +
                            "huhtikuussa on 30 paivaa,\n" +
                            "toukokuussa on 31 paivaa,\n" +
                            "kesakuussa on 30 paivaa,\n" +
                            "heinakuussa on 31 paivaa,\n" +
                            "elokuussa on 31 paivaa,\n" +
                            "syyskuussa on 30 paivaa,\n" +
                            "lokakuussa on 31 paivaa,\n" +
                            "marraskuussa on 30 paivaa,\n" +
                            "joulukuussa on 31 paivaa.\n");
                }

                // Muulloin kyseessä ei ole karkausvuosi
                else {
                    System.out.println("Vuosi " + vuosiLuku + " ei ole karkausvuosi, ja sen \n" +
                            "tammikuussa on 31 paivaa,\n" +
                            "helmikuussa on 28 paivaa,\n" +
                            "maaliskuussa on 31 paivaa,\n" +
                            "huhtikuussa on 30 paivaa,\n" +
                            "toukokuussa on 31 paivaa,\n" +
                            "kesakuussa on 30 paivaa,\n" +
                            "heinakuussa on 31 paivaa,\n" +
                            "elokuussa on 31 paivaa,\n" +
                            "syyskuussa on 30 paivaa,\n" +
                            "lokakuussa on 31 paivaa,\n" +
                            "marraskuussa on 30 paivaa,\n" +
                            "joulukuussa on 31 paivaa.\n");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Virhe syotteessa! Ohjelma suljetaan.");
        }
    }
}
