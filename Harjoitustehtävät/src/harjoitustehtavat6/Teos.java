/**
 * Juuso Uusimäki, 26.1.2019, Ohjelmointi III - Harjoitustehtävät 6.
 * <p>
 * 1. Toteuta Teos-luokka kirjastokäyttöön. Luokan tulee sisältää ainakin seuraavat attribuutit:
 * <p>
 * Tekijä, teoksen nimi, genre, ISBN, sivumäärä ja tila. Tila-attribuutti kertoo, onko teos saatavilla,
 * lainassa, hävinnyt tms.
 * <p>
 * Luokan tulee sisältää ainakin seuraavan toiminnallisuuden mahdollistavat metodit:
 * <p>
 * Teoksen tila täytyy voida muuttaa ja tarkistaa tai tulostaa.
 * Teoksen tiedot täytyy voida syöttää käyttäjän toimesta.
 * Teoksen tiedot täytyy voida tulostaa käyttäjälle.
 * <p>
 * Laadi lisäksi pääohjelma, jossa testaat luomasi luokan toiminnallisuuden.
 */

package harjoitustehtavat6;

// Luodaan Teos-luokka

public class Teos {

    // Konstruktori (no argument)
    public Teos() {

    }

    // Luodaan attribuutit
    private String m_tekija, m_teosNimi, m_genre, m_isbn, m_tila;
    private int m_sivuMaara;

    // Luodaan metodeja

    // Tietojen syöttömetodit
    public void setTekija(String tekija) {
        m_tekija = tekija;
    }

    public void setTeosNimi(String teosnimi) {
        m_teosNimi = teosnimi;
    }

    public void setGenre(String genre) {
        m_genre = genre;
    }

    public void setISBN(String isbn) {
        m_isbn = isbn;
    }

    public void setTila(String tila) {
        m_tila = tila;
    }

    public void setSivumaara(int sivumaara) {
        m_sivuMaara = sivumaara;
    }

    public void showTila() {
        System.out.println("Teoksen tila on " + m_tila + ".");
    }

    public void showTiedot() {
        System.out.println("Teoksen tekija on " + m_tekija + ", nimi " + m_teosNimi + ", sivumaara " + m_sivuMaara +
                ", genre " + m_genre + ", ISBN " + m_isbn + ".");
    }
}
