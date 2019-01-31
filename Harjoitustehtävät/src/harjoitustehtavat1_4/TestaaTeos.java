package harjoitustehtavat1_4;

/**
 * Juuso Uusimäki, 26.1.2019, Ohjelmointi III - Harjoitustehtävät 6.
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

public class TestaaTeos {
    public static void main(String[] args) {

        Teos Teos1;
        Teos1 = new Teos();

        Teos1.setTekija("Dan Simmons");
        Teos1.setTeosNimi("The Fall of Hyperion");
        Teos1.setGenre("Sci-Fi");
        Teos1.setISBN("951-578-578-2");
        Teos1.setSivumaara(574);
        Teos1.setTila("lainattu");
        Teos1.showTila();
        Teos1.showTiedot();
    }
}