/**
 * Juuso Uusimäki, 3.3.2019, Ohjelmointi III - Tentti
 *
 * 3. Toteuta luokka Asiakkaat, joka on tehty Asiakas (tehtävä 1) -olioiden käsittelyä varten.
 * (Tallenna Asiakas-oliot listalle tai taulukkoon.) Vaikka et saisi tehtyä tehtävää 1,
 * voit kirjoittaa metodien esittelyrivit ja käyttää metodeja. Katso valmiista pääohjelmasta,
 * miten metodit on määritelty (AsPaa.java).
 * Luokassa Asiakkaat on metodit seuraavia toimenpiteitä varten
 * - lisätään Asiakas-olio, kun Asiakas-olio on parametrina
 * - palautetaan Asiakas-olio parametrina annetun nimen perusteella
 * - tulostetaan kaikki KantaAsiakkaat tai ilmoitetaan, ettei heitä ole
 * - palautetaan eniten ostoja tehneen asiakkaan nimi
 * Laita pääohjelman AsPaa tuottama tulostus kommenttina ohjelmaan.
 *
 */

/*
Kanta-asiakkaita ei loytynyt.
Kanta-asiakas loytyi: KantaAsiakas{sahkoposti='vaarala@gmail.com', vuosi=123, nimi='Ville Vaara', tunnus=1980, osoite='Mutalalantie 4, 80100 Joensuu', ostosSumma=320.95}
Suurin asiakas Maija Meri
Asiakas{nimi='Maija Meri', tunnus=11, osoite='Leilitie 12, 80100 Joensuu', ostosSumma=423.45}
*/

package tentti;

import java.util.*;

public class Asiakkaat {

    // Luodaan ArrayList asiakkaista
    List<Asiakas> asiakasLista = new ArrayList<>();

    // Metodit

    // Lisätään asiakaslistaan asiakas
    public void lisaaAsiakas(Asiakas asiakas) {
        asiakasLista.add(asiakas);
    }

    // Haetaan asiakas nimen perusteella
    public Asiakas getAsiakas(String haettavaNimi) {

        // Käydään asiakasLista läpi
        for (int i = 0; i < asiakasLista.size(); i++) {
            // Etsitään asiakasta nimen perusteella, ja palautetaan kyseinen olio
            if (haettavaNimi.equals(asiakasLista.get(i).nimi)){
                return asiakasLista.get(i);
            }
        }
        // Jos asiakasta ei nimen perusteella löydy, ilmoitetaan asiasta
        System.out.println("Asiakasta ei loytynyt");
        return null;
    }

    // Tulostetaan kanta-asiakkaat tai ilmoitetaan, ettei heitä ole
    public void tulostaKantaAsiakkaat() {

        // Luodaan attribuutti, jonka mukaan tulostetaan, jos kanta-asiakkaita ei löydy
        boolean loytyi = false;

        // Käydään asiakasLista läpi
        for (int i = 0; i < asiakasLista.size(); i++) {
            // Etsitään kanta-asiakkaita instanceof avulla, ja tulostetaan tiedot löytyessä
            if(asiakasLista.get(i) instanceof KantaAsiakas) {
                System.out.println("Kanta-asiakas loytyi: " + asiakasLista.get(i).toString());
                loytyi = true;
            }
        }

        // Jos kanta-asiakkaita ei löytynyt, tulostetaan ilmoitus
        if (!loytyi) {
            System.out.println("Kanta-asiakkaita ei loytynyt.");
        }
    }

    // Haetaan eniten ostoja tehneen asiakkaan nimi
    public String enitenOstoja() {
        // Järjestetään, ja huomioidaan Collections-luokan oletusjärjestys (ascending)
        Collections.sort(asiakasLista, Collections.reverseOrder());
        return asiakasLista.get(0).nimi;
    }
}


