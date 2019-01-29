/**
 * Juuso Uusimäki, 29.1.2019, Ohjelmointi III - Harjoitustehtävät 6.
 *
 * 2. Laadi pelihahmo-luokka, joka sisältää ainakin seuraavat attribuutit:
 *
 * Nimi, hahmoluokka (esim. soturi, varas, velho, ..), sukupuoli, ikä ja ase.
 *
 * Toteuta hahmoluokka ja ase omina luokkinaan ja käytä niitä pelihahmo-luokan attribuutteina.
 *
 * Hahmoluokka sisältää ainakin seuraavat attribuutit:
 *
 * Luokan nimi, hahmon taso ja erityistaidot.
 *
 * Ase-luokka sisältää ainakin seuraavat attribuutit:
 *
 * Tyyppi, vahinko ja bonukset.
 *
 * Kaikissa toteutettavissa luokissa tulee olla metodit tietojen kyselemistä ja tulostamista varten.
 *
 * Attribuuttien tyypit voit valita parhaaksi katsomallasi tavalla.
 *
 * Laadi lisäksi pääohjelma, jossa testaat luomiesi luokkien toiminnallisuuden.
 *
 */

package harjoitustehtavat6;

public class Pelihahmo {

    // Pääohjelma
    public static void main(String[] args) {

        // Luodaan oliot luokista
        Pelihahmo pelihahmo = new Pelihahmo();
        Hahmoluokka hahmoluokka = new Hahmoluokka();
        Ase ase = new Ase();

        // Asetetaan attribuuteille arvot
        pelihahmo.setNimi("Allu");
        pelihahmo.setSukupuoli("Male");
        pelihahmo.setIka(25);
        hahmoluokka.setErityisTaidot("Raging Storm");
        hahmoluokka.setNimi("Monk");
        hahmoluokka.setTaso(126);
        ase.setBonukset("Fear");
        ase.setTyyppi("Two-handed maul");
        ase.setVahinko(4);

        // Asetetaan arvo luodun olion avulla
        pelihahmo.setHahmoluokka(hahmoluokka);
        pelihahmo.setAse(ase);

        // Ajetaan tietojen tulostus
        pelihahmo.tulosta();

    }

    // Luodaan attribuutit
    private String nimi;
    private String sukupuoli;
    private int ika;
    private Hahmoluokka hahmoluokka;
    private Ase ase;

    // Luodaan metodit: Tietojen tulostus, getterit ja setterit

    public void tulosta(){
        System.out.println(this.toString());
        System.out.println(this.getAse().toString());
        System.out.println(this.getHahmoluokka().toString());
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getSukupuoli() {
        return sukupuoli;
    }

    public void setSukupuoli(String sukupuoli) {
        this.sukupuoli = sukupuoli;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }

    public Hahmoluokka getHahmoluokka() {
        return hahmoluokka;
    }

    public void setHahmoluokka(Hahmoluokka hahmoluokka) {
        this.hahmoluokka = hahmoluokka;
    }

    public Ase getAse() {
        return ase;
    }

    public void setAse(Ase ase) {
        this.ase = ase;
    }

    // Palauttaa olion tiedot Stringinä
    @Override
    public String toString() {
        return "Pelihahmo{" +
                "nimi='" + nimi + '\'' +
                ", sukupuoli='" + sukupuoli + '\'' +
                ", ika=" + ika +
                '}';
    }

}

// Luodaan vaadittava luokka erikseen
class Hahmoluokka {

    // Luodaan attribuutit
    private String nimi;
    private int taso;
    private String erityisTaidot;

    // Luodaan metodit
    public void tulosta(){
        System.out.println(this.toString());
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getTaso() {
        return taso;
    }

    public void setTaso(int taso) {
        this.taso = taso;
    }

    public String getErityisTaidot() {
        return erityisTaidot;
    }

    public void setErityisTaidot(String erityisTaidot) {
        this.erityisTaidot = erityisTaidot;
    }

    @Override
    public String toString() {
        return "Hahmoluokka{" +
                "nimi='" + nimi + '\'' +
                ", taso=" + taso +
                ", erityisTaidot='" + erityisTaidot + '\'' +
                '}';
    }


}

// Luodaan vaadittavat luokka erikseen samoin kuin Hahmoluokka
class Ase {

    private String tyyppi;
    private int vahinko;
    private String bonukset;


    public void tulosta(){
        System.out.println(this.toString());
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public int getVahinko() {
        return vahinko;
    }

    public void setVahinko(int vahinko) {
        this.vahinko = vahinko;
    }

    public String getBonukset() {
        return bonukset;
    }

    public void setBonukset(String bonukset) {
        this.bonukset = bonukset;
    }

    @Override
    public String toString() {
        return "Ase{" +
                "tyyppi='" + tyyppi + '\'' +
                ", vahinko=" + vahinko +
                ", bonukset='" + bonukset + '\'' +
                '}';
    }
}
