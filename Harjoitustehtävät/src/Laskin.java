/**
 *
 * Juuso Uusimäki, 15.1.2019, Ohjelmointi III - Harjoitustehtävät 4.
 *
 * 2. Laadi ohjelma, joka toimii erittäin pelkistettynä laskimena.
 * Ohjelma kysyy käyttäjältä kaksi lukua (operandia) ja luvun,
 * joka kertoo kyseessä olevan operaattorin (+, -, *, tai /).
 * Tämän jälkeen ohjelma suorittaa pyydetyn laskutoimituksen ja
 * tulostaa vastauksen. Käytä ohjelmassasi switch-lausetta.
 *
 */

import java.util.*;

public class Laskin {
    public static void main(String[] args) {

        Scanner lukija;
        lukija = new Scanner(System.in);

        double luku1 = 0; // Luodaan luvut laskutoimituksia varten
        double luku2 = 0;
        byte valinta = 0; // Sekä laskutoimituksen valintanumero

        try {

            // Kysytään käyttäjältä luvut ja luetaan ne muuttujiin
            System.out.println("Syota ensimmainen luku: ");
            luku1 = lukija.nextDouble();
            System.out.println("Syota toinen luku: ");
            luku2 = lukija.nextDouble();

            System.out.println("Valitse laskuoperaatio: summa (1), erotus (2), tulo (3) tai osamaara (4).");
            valinta = lukija.nextByte();

            // Suoritetaan laskutoimituksen valinta ja ilmoitus switch-lauseella ja tapauksilla
            switch (valinta) {
                case 1: System.out.println("Lukujen summa on " + (luku1+luku2) + "."); break;
                case 2: System.out.println("Lukujen erotus on " + (luku1-luku2) + "."); break;
                case 3: System.out.println("Lukujen tulo on " + (luku1*luku2) + "."); break;
                case 4: System.out.println("Lukujen osamaara on " + (luku1/luku2) + "."); break;
                default : System.out.println("Epakelpo valinta."); break;
            }


        } catch (InputMismatchException e) {
            System.out.println("Virhe syotteessa! Ohjelma sulkeutuu.");
        }
    }
}


