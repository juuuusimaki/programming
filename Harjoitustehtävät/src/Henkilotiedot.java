/**
 Juuso Uusimäki, 6.1.2019, Ohjelmointi III - Harjoitustehtävät 2.

 1. Laadi ohjelma, joka kysyy käyttäjältä kuvitteellisen henkilön seuraavat tiedot:
 ikä, pituus metreinä, paino sekä tieto siitä, omistaako kyseinen henkilö ajokortin.
 Valitse tarvittavien muuttujien tietotyypit siten, että ne vievät mahdollisimman vähän turhaa tilaa.
 Kun olet kysynyt tiedot käyttäjältä, tulosta ne näytölle.
 Mikäli pystyt tekemään tulostuksestasi elegantimpaa hyödyntämällä ratkaisussasi  ehtolausetta, saat yhden bonuspisteen.
 */

import java.util.*; // Tuodaan kirjasto, jossa Scanner-luokka on


class Henkilotiedot { // Luodaan henkilotiedot-luokka
    public static void main(String[] args) {

        Scanner lukija; // Määritellään syötteiden lukemisesta vastaava olio
        lukija = new Scanner(System.in); // Luodaan kyseinen olio

        // Luodaan ja alustetaan muuttujat, ja huomioidaan niille sopivat tietotyypit
        byte ika = 0; // Vuosia - tarvitaan vain suhteellisen pieniä kokonaislukuja
        short paino = 0; // Kilogrammoja - tarvitaan kokonaislukuja
        float pituus = 0; // Metrejä - tarvitaan desimaaleja
        char ajokortti = 'x'; // K/E riittää

        // Kysytään syötteitä käyttäjältä

        try { // Koitetaan syötteen lukemista
            System.out.println("Syota ikasi vuosina: ");
            ika = lukija.nextByte(); // Luetaan byte
            System.out.println("Syota painosi kiloina (kokonaisluku): ");
            paino = lukija.nextShort(); // Luetaan short
            System.out.println("Syota pituutesi metreina (pilkulla): ");
            pituus = lukija.nextFloat(); // Luetaan liukuluku
            System.out.println("Onko sinulla ajokorttia? K/E: ");
            ajokortti = lukija.next().charAt(0); // Luetaan kirjain
            ajokortti = Character.toUpperCase(ajokortti); // Jos annettu pieni k/e, muutetaan isoksi K/E
            lukija.close(); // Suljetaan lukija
        }

        catch (InputMismatchException e) { // Jos syötteen lukemisessa tuli tyyppivirhe, napataan se
            System.out.println("Virhe syotteiden lukemisessa!");
            System.exit(0); // Poistutaan ohjelmasta
        }
        catch (Exception e) { // Otetaan kiinni muita poikkeuksia ja poistutaan ohjelmasta
            System.out.println("Virhe ohjelman suorituksessa. Ohjelma loppuu.");
            System.exit(1);
        }

        // Hyödynnetään ehtolauseita tulostuksessa, riippuen siitä, onko henkilöllä ajokortti
        if (ajokortti == 'K' ) {
            System.out.println("Henkilon ika on " + ika + " vuotta, paino " + paino + " kilogrammaa, pituus " + pituus + " metria, ja henkilolla on ajokortti.");
        }
        else if (ajokortti == 'E') {
            System.out.println("Henkilon ika on " + ika + " vuotta, paino " + paino + " kilogrammaa, pituus " + pituus + " metria, ja henkilolla ei ole ajokorttia.");
        }
        else {
            //if (ajokortti != 'K' && ajokortti != 'E'){
            System.out.println("Ajokortin syottaminen epaonnistui. Yrita uudelleen!");
        }
    }
}

/**

 2. Laadi ohjelma, joka kysyy käyttäjältä seitsemän viikonpäivän sademäärät, jotka se tulostaa näytölle.
 Käytä ohjelmassasi vakiota ja taulukkoa. Mikäli pystyt toteuttamaan tietojen kysymisen käyttäjältä
 ja tietojen tulostamisen näytölle tehokkaammin käyttämällä toistolausetta, voit saada yhteensä kaksi bonuspistettä.

 */