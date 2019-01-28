package harjoitustehtavat6;

import java.util.*;

public class TestaaTeos {
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        Teos teos1;
        teos1 = new Teos();

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

        teos1.showTila();
        teos1.showTiedot();
    }
}
