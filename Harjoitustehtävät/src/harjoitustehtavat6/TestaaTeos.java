/**
 * Juuso Uusimäki, 29.1.2019, Ohjelmointi III - Harjoitustehtävät 6.
 *
 * 1. Toteuta Teos-luokka kirjastokäyttöön. Luokan tulee sisältää ainakin seuraavat attribuutit:
 *
 * Tekijä, teoksen nimi, genre, ISBN, sivumäärä ja tila. Tila-attribuutti kertoo, onko teos saatavilla,
 * lainassa, hävinnyt tms.
 *
 * Luokan tulee sisältää ainakin seuraavan toiminnallisuuden mahdollistavat metodit:
 *
 * Teoksen tila täytyy voida muuttaa ja tarkistaa tai tulostaa.
 * Teoksen tiedot täytyy voida syöttää käyttäjän toimesta.
 * Teoksen tiedot täytyy voida tulostaa käyttäjälle.
 *
 * Laadi lisäksi pääohjelma, jossa testaat luomasi luokan toiminnallisuuden.
 *
 */

// Pääohjelma tehtävälle 6.1.

package harjoitustehtavat6;

import java.util.*;

public class TestaaTeos {
    public static void main(String[] args) {

        // Luodaan lukija
        Scanner lukija = new Scanner(System.in);

        // Luodaan uusi olio teoksesta
        Teos teos1;
        teos1 = new Teos();

        // Kysytään käyttäjältä syötteitä, ja syötetään ne metodeihin
        System.out.println("Syota teoksen tiedot: ");
        System.out.println("Tekija: ");
        teos1.setTekija(lukija.nextLine());
        System.out.println("Nimi: ");
        teos1.setTeosNimi(lukija.nextLine());
        System.out.println("Genre: ");
        teos1.setGenre(lukija.nextLine());
        System.out.println("ISBN: ");
        teos1.setISBN(lukija.nextLine());
        System.out.println("Sivumaara: ");
        teos1.setSivumaara(lukija.nextInt());
        lukija.nextLine();
        System.out.println("Tila: ");
        teos1.setTila(lukija.nextLine());

        // Tutkitaan, onko teos esim. lainattu, ja tulostetaan kaikki tiedot
        teos1.getTila("lainattu");
        teos1.getTiedot();
    }
}
