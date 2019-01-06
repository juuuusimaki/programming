import java.util.*;

public class Poikkeukset2 {
    public static void main(String[] args) {
        int[] kokonaislukuTaulukko; // Esitetään taulukko
        kokonaislukuTaulukko = new int[10]; // 10 alkion kokoinen kokonaislukutaulukko

        int luku = 0; // Esitetään ja alustetaan tarvittavat muuttujat syötteiden lukua varten
        Scanner lukija;
        lukija = new Scanner(System.in);

        Locale.setDefault(Locale.ENGLISH); // Asetetaan desimaalierotin pisteeksi

        do { // Yritetään lukea käyttäjältä syötteitä, kunnes käyttäjä haluaa lopettaa


            // Yritetään erilaisia tilanteita, joissa virheitä saattaa tulla
            try {
                System.out.println("Anna luku (lopeta antamalla -1): ");
                luku = lukija.nextInt();

                if (luku != -1) {
                    System.out.println("Antamasi luvun toinen potenssi on: " + (luku * luku));
                }

                if (luku == 1) {
                    kokonaislukuTaulukko[5] = 5;
                }


            }

            catch (InputMismatchException e) { // Otetaan kiinni poikkeuksia
                System.out.println("Syötettu luku ei ole kokonaisluku.");
                lukija = new Scanner(System.in);
                luku = 0;
            }

            catch (Exception e) { // Otetaan kiinni poikkeuksia
                System.out.println("Virhe ohjelman suorituksessa. Ohjelma loppuu.");
                System.exit(1);
            }
        } while (luku != -1); // Suoritetaan do-silmukkaa kunnes käyttäjä syöttää luvun -1.
    }
}