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

package harjoitustehtavat6;

// Luodaan Teos-luokka

public class Teos {

    // Luodaan attribuutit
    private String m_tekija, m_teosNimi, m_genre, m_isbn, m_tila;
    private int m_sivuMaara;

    // Luodaan metodeja

    // Tietojen syöttömetodit
    public void setTekija(String tekija) { m_tekija = tekija; }

    public void setTeosNimi(String teosnimi) { m_teosNimi = teosnimi; }

    public void setGenre(String genre) { m_genre = genre; }

    public void setISBN(String isbn) {
        m_isbn = isbn;
    }

    public void setTila(String tila) {
        m_tila = tila;
    }

    public void setSivumaara(int sivumaara) {
        m_sivuMaara = sivumaara;
    }

    // Tilan tarkistusmetodi
    public void getTila(String tila) {
        if (m_tila.equals(tila)) { // Tarkistetaan, josko tarkistettava tila on sama kuin syötetty
            System.out.println("Teoksen tila: " + m_tila + ".");
        } else {
            System.out.println("Teoksen tila ei ole " + tila + ", vaan " + m_tila + ".");
        }
    }

    // Tietojen tulostusmetodi
    public void getTiedot() {
        System.out.println("Teoksen tekija on " + m_tekija + ", nimi " + m_teosNimi + ", sivumaara " + m_sivuMaara +
                ", genre " + m_genre + ", ISBN " + m_isbn + ".");
    }
}
