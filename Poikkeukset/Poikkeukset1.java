import java.util.*;

public class Poikkeukset1 {
    public static void main(String[] args) {
        int[] kokonaislukuTaulukko; // Esitetään taulukko
        kokonaislukuTaulukko = new int[10]; // 10 alkion kokoinen kokonaislukutaulukko

        int lukuA; // Esitetään ja alustetaan tarvittavat muuttujat syötteiden lukua varten
        Scanner lukija;
        lukija = new Scanner(System.in);



        // Yritetään erilaisia tilanteita, joissa virheitä saattaa tulla
        try {
            System.out.println("Anna luku: ");
            lukuA = lukija.nextInt();
            kokonaislukuTaulukko[10] = lukuA;
        } catch (Exception e) { // Otetaan kiinni poikkeuksia
            System.out.println("Virhe ohjelman suorituksessa. Ohjelma loppuu.");
            System.exit(1);
        }
    }
}