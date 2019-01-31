package harjoitustehtavat1_4; /**
 Juuso Uusimäki, 6.1.2019, Ohjelmointi III - Harjoitustehtävät 2.

 2. Laadi ohjelma, joka kysyy käyttäjältä seitsemän viikonpäivän sademäärät, jotka se tulostaa näytölle.
 Käytä ohjelmassasi vakiota ja taulukkoa. Mikäli pystyt toteuttamaan tietojen kysymisen käyttäjältä
 ja tietojen tulostamisen näytölle tehokkaammin käyttämällä toistolausetta, voit saada yhteensä kaksi bonuspistettä.
 */

import java.util.*; // Tuodaan kirjasto, jossa Scanner-luokka on

public class Sademaarat { // Luodaan Sademaarat-luokka
    public static void main(String[] args) {

        Scanner lukija; // Määritellään ja luodaan lukija-olio
        lukija = new Scanner(System.in);

        float[] sademaaraTaulukko; // Luodaan taulukko, johon sademaarat tallennetaan
        sademaaraTaulukko = new float[7];

        final String[] viikonpaivat; // Luodaan viikonpaivataulukko, joka vakioidaan
        viikonpaivat = new String[7];

        viikonpaivat[0] = "Maanantai"; // Syotetaan taulukkoon viikonpaivat
        viikonpaivat[1] = "Tiirstai";
        viikonpaivat[2] = "Keskiviikko";
        viikonpaivat[3] = "Torstai";
        viikonpaivat[4] = "Perjantai";
        viikonpaivat[5] = "Lauantai";
        viikonpaivat[6] = "Sunnuntai";

        // Kysytään käyttäjältä sademääriä viikonpäiville for-toistolauseen avulla.
        System.out.println("Syota viikonpaivien sademaarat millimetreina (kayta desimaaliluvuissa pilkkua): " +"\n");
        for (int i = 0; i < 7;i++) {
            System.out.println(viikonpaivat[i] + "n sademaara: "); // Haetaan viikonpaivat-taulukosta oikea päivä
            sademaaraTaulukko[i] = lukija.nextFloat(); // Sijoitetaan annettu luku sademaaraTaulukkoon kyseisen paivan indeksille
        }

        // Tulostetaan syötetyt tiedot vastaavien viikonpäivien kera for-toistolauseen avulla.
        System.out.println("\n" + "Viikonpaivien sademaarat ovat: " +"\n");
        for (int k = 0; k<7; k++) {
            System.out.println(viikonpaivat[k] + ": " + sademaaraTaulukko[k] + " millimetria."); // Haetaan oikea viikonpäivä ja sitä vastaava sademäärä
        }
    }
}
