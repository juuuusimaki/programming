/**************************************
 *
 * Name: Summa
 * Creator: Juuso Uusimäki
 * Date: 5.1.2019
 *
 */

import java.util.*; // Tuodaan kirjasto, jossa Scanner-luokka on. Lisää tämä rivi myös virheenkäsittelyn yhteydessä saadaksesi poikkeukset käyttöösi.

// Summa-luokka
public class Summa {
    public static void main(String[] args) {
        int lukuA=0, lukuB=0, summa=0;

        Locale.setDefault(Locale.ENGLISH); // Asetetaan oletuskieli englanniksi, mikäli halutaan käyttää desimaalierottimena pistettä pilkun sijaan
        Scanner lukija; // Määritellään syötteiden lukemisesta vastaava olio.
        lukija = new Scanner(System.in); // Luodaan kyseinen olio
        try { // Koitetaan syötteen lukemista
            System.out.println("Anna ensimmäinen luku: ");
            lukuA = lukija.nextInt();
            System.out.println("Anna toinen luku: ");
            lukuB = lukija.nextInt();
        }
        catch (InputMismatchException e) { // Jos syötteen lukemisessa tuli virhe, napataan se
            System.out.println("Virhe syötteiden lukemisessa!");
            System.exit(0); // Poistutaan ohjelmasta
        }
        summa = lukuA + lukuB;
        System.out.println("Summa on " + summa + ".");
    }
}