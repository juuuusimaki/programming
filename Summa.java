import java.util.*; // Tuodaan kirjasto, jossa Scanner-luokka on. Lisää tämä rivi myös virheenkäsittelyn yhteydessä saadaksesi poikkeukset käyttöösi.

public class Summa {
    public static void main(String[] args) {
        int lukuA, lukuB, summa;

        Locale.setDefault(Locale.ENGLISH); // Asetetaan oletuskieli englanniksi, mikäli halutaan käyttää desimaalierottimena pistettä pilkun sijaan
        Scanner lukija; // Määritellään syötteiden lukemisesta vastaava olio.
        lukija = new Scanner(System.in); // Luodaan kyseinen olio
        System.out.println("Anna ensimmäinen luku: ");
        lukuA = lukija.nextInt();
        System.out.println("Anna toinen luku: ");
        lukuB = lukija.nextInt();
        summa = lukuA + lukuB;
        System.out.println("Summa on " + summa);
    }
}