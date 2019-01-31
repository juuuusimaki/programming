/**
 * Juuso Uusimäki, 31.1.2019, Ohjelmointi III - Harjoitustehtävät 7.
 *
 * 1. Toteuta sopivaksi katsomasi luokkahierarkia seuraavan kuvauksen pohjalta (hyödynnä periytymistä):
 *
 * Eläimellä on nimi ja se voi olla elossa tai kuollut. Eläimelle voi antaa nimen, jonka käyttäjä voi myös selvittää/tulostaa.
 *
 * Käyttäjä voi myös selvittää, onko eläin elossa vai kuollut, sekä asettaa eläimen tilan kuolleeksi.
 *
 * Kissa perii eläimen ominaisuudet. Lisäksi sillä on useita elämiä, jotka käyttäjä voi asettaa.
 *
 * Käyttäjä voi myös vähentää kissan elämiä, sekä selvittää niiden lukumäärän.
 *
 * Myös papukaija perii eläimen ominaisuudet. Lisäksi sillä on merirosvoisäntä, jonka käyttäjä voi asettaa.
 *
 * Käyttäjä voi myös selvittää merirosvoisännän nimen.
 *
 * Myös lammas perii eläimen ominaisuudet. Lisäksi se voi olla joko valkoinen tai musta lammas.
 *
 * Oletuksena lammas on valkoinen mutta käyttäjä voi muuttaa lampaan mustaksi ja takaisin valkoiseksi. Käyttäjä voi myös selvittää lampaan värin.
 *
 * Laadi lisäksi pääohjelma, jossa testaat luomiesi luokkien toiminnallisuuden.
 *
 */


package harjoitustehtavat7;

public class PeriytyvaElain {

    // Pääohjelma
    public static void main(String[] args) {

        // Luodaan oliot
        Kissa kissa = new Kissa();
        Papukaija papukaija = new Papukaija();
        Lammas lammas = new Lammas();

        // Asetetaan attribuuteille arvot
        kissa.setNimi("Lulu"); // Nimetään kisse
        kissa.getNimi();
        kissa.setStatus("elossa"); // Kissa olkoon elossa
        kissa.getStatus();
        kissa.setElamaMaara(9); // Laitetaan kissalle elämiä
        kissa.vahennaElamat(10); // Ja vähennetään haluttu määrä. Jos vahennetaan enemman kuin elamien maara,
        // status vaihtuu "kuollut", ja elamien lukumaara 0.
        kissa.getElamaMaara();

        papukaija.setNimi("Papu"); // Nimi papukaijalle
        papukaija.getNimi();
        papukaija.setStatus("kuollut"); // Papukaija on kuollut..
        papukaija.getStatus();
        papukaija.setMerirosvoIsanta("Kaija"); // Nimetään papukaijan isäntä
        papukaija.getMerirosvoIsanta();

        lammas.setNimi("Pilvi");
        lammas.getNimi();
        lammas.setStatus("elossa");
        lammas.getStatus();
        lammas.setVari("musta"); // Lammas olkoon musta
        lammas.getVari();

        kissa.tulostaTiedot();
        papukaija.tulostaTiedot();
        lammas.tulostaTiedot();


    }

    // Luokan tiedot

    // Luodaan pääluokan attribuutit
    private String nimi; // Eläimen nimi
    private String status; // status - kuollut tai elossa

    // Luodaan metodit, getterit ja setterit

    public void tulostaTiedot() {
        System.out.println(this.toString());
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("elossa") || status.equals("kuollut")) { // Hyväksytään vain nämä vaihtoehdot
            this.status = status;
        } else {
            System.out.println("Elaimen on oltava elossa tai kuollut!");
        }
    }



}

// Luokka, joka perii eläimen ominaisuudet
class Kissa extends PeriytyvaElain {

    // Vain Kissa-luokan attribuutti
    private int elamaMaara;

    // Elämien vähentämismetodi, sekä getterit ja setterit
    public int vahennaElamat(int lukumaara) {
        this.elamaMaara -= lukumaara;
        if (this.elamaMaara < 1) {
            this.setStatus("kuollut");
            this.elamaMaara = 0;
        }
        return elamaMaara;
    }

    public int getElamaMaara() {
        return elamaMaara;
    }

    public void setElamaMaara(int elamaMaara) {
        this.elamaMaara = elamaMaara;
    }



    @Override
    public String toString() {
        return "Kissan nimi on " + getNimi() + ", status " + getStatus() + ", ja elamien maara " + getElamaMaara() + ".";
    }
}

// Luokka, joka perii eläimen ominaisuudet
class Papukaija extends PeriytyvaElain {

    // Attribuutti
    private String merirosvoIsanta;

    // Metodit - getteri ja setterireturn super.toString();
    public String getMerirosvoIsanta() {
        return merirosvoIsanta;
    }

    public void setMerirosvoIsanta(String merirosvoIsanta) {
        this.merirosvoIsanta = merirosvoIsanta;
    }

    @Override
    public String toString() {
        return "Papukaijan nimi on " + getNimi() + ", status " + getStatus() + ", ja merirosvoisanta " + getMerirosvoIsanta() + ".";
    }
}

// Luokka, joka perii eläimen ominaisuudet
class Lammas extends PeriytyvaElain {

    // Attribuutti, jonka oletusarvo on valkoinen
    private String vari;

    // Konstruktori, jonka oletusarvona väri on valkoinen
    public Lammas() {
        vari = "valkoinen";
    }


    // Metodit - getteri ja setteri, joka vastaa lampaan värityksen säätämisestä
    public String getVari() {
        return vari;
    }

    public void setVari(String vari) {
        if (vari.equals("valkoinen") || vari.equals("musta")) { // Hyväksytään vain nämä vaihtoehdot
            this.vari = vari;
        } else {
            System.out.println("Lammas voi olla vain valkoinen tai musta!");
        }
    }

    @Override
    public String toString() {
        return "Lampaan nimi on " + getNimi() + ", status " + getStatus() + ", ja vari " + getVari() + ".";
    }
}

