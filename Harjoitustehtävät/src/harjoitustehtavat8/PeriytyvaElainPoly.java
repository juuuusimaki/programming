/**
 * Juuso Uusimäki, 10.2.2019, Ohjelmointi III - Harjoitustehtävät 8.
 *
 * 1. Lisää Harjoitustehtävät 7 luokkiin seuraava toiminnallisuus polymorfismia hyödyntäen:
 *
 * Määrittele eläin-luokka abstraktiksi ja lisää siihen abstrakti puhu-metodi.
 * Toteuta tämän jälkeen kissalle, papukaijalle ja lampaalle omat toteutuksensa puhu-metodille.
 * Lisää lopuksi pääohjelmaan osio, jossa lisäät kissan, papukaijan ja lampaan samaan eläin-taulukkoon
 * ja käyt taulukon alkiot läpi kutsuen jokaisen kohdalla puhu-metodia.
 * Tällöin jokaisen eläimen tulisi puhua lajilleen ominaisella tavalla.
 *
 */

package harjoitustehtavat8;

abstract class PeriytyvaElainPoly {

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

        // HT 8: Luodaan oliotaulukko, johon kukin olio sijoitetaan
        PeriytyvaElainPoly[] elainTaulukko = new PeriytyvaElainPoly[3];
        elainTaulukko[0] = kissa;
        elainTaulukko[1] = papukaija;
        elainTaulukko[2] = lammas;

        // Kutsutaan kunkin taukukon olion puhu-metodia
        for (int i = 0; i < 3; i++) {
            System.out.println(elainTaulukko[i].puhu());
        }

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
        if ("elossa".equals(status) || "kuollut".equals(status)) { // Hyväksytään vain nämä vaihtoehdot
            this.status = status;
        } else {
            System.out.println("Elaimen on oltava elossa tai kuollut!");
        }
    }

    // Luodaan vielä HT 8:n vaatima abstrakti puhu-metodi
    public abstract String puhu();

}

// Luokka, joka perii eläimen ominaisuudet
class Kissa extends PeriytyvaElainPoly {

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

    // HT 8:n puhu-metodi kissalle
    @Override
    public String puhu() {
        return "Miau!";
    }

    @Override
    public String toString() {
        return "Kissan nimi on " + getNimi() + ", status " + getStatus() + ", ja elamien maara " + getElamaMaara() + ".";
    }
}

// Luokka, joka perii eläimen ominaisuudet
class Papukaija extends PeriytyvaElainPoly {

    // Attribuutti
    private String merirosvoIsanta;

    // Metodit - getteri ja setterireturn super.toString();
    public String getMerirosvoIsanta() {
        return merirosvoIsanta;
    }

    public void setMerirosvoIsanta(String merirosvoIsanta) {
        this.merirosvoIsanta = merirosvoIsanta;
    }

    // HT 8:n puhu-metodi papukaijalle
    @Override
    public String puhu() {
        return "Olen papukaija!";
    }

    @Override
    public String toString() {
        return "Papukaijan nimi on " + getNimi() + ", status " + getStatus() + ", ja merirosvoisanta " + getMerirosvoIsanta() + ".";
    }
}

// Luokka, joka perii eläimen ominaisuudet
class Lammas extends PeriytyvaElainPoly {

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

    // HT 8:n puhu-metodi lampaalle
    @Override
    public String puhu() {
        return "Baaaaa!";
    }

    @Override
    public String toString() {
        return "Lampaan nimi on " + getNimi() + ", status " + getStatus() + ", ja vari " + getVari() + ".";
    }
}

