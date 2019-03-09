package tentti;

/*
 * Tämä koodi liittyy uusintatentin tehtävään 3, mutta saat tästä vinkkiä myös tehtävien 1 ja 2 metodeihin
 */
public class AsPaa {
    public static void main(String[] args) {
// luodaan uusi Asiakkaat-luokan ilmentymä l. olio
        Asiakkaat kauppa = new Asiakkaat();
// luodaan asiakas Maija
        Asiakas eka = new Asiakas("Maija Meri", 11, "Leilitie 12, 80100 Joensuu");
// Kasvatetaan Maijan ostosten summaa
        eka.lisaaOstosSummaan(423.45);
// lisätään Maijan tiedot Asiakkaat-luokan kokoelmaan
        kauppa.lisaaAsiakas(eka);
// tulostetaan kokoelmasta kaikki kanta-asiakkaat
        kauppa.tulostaKantaAsiakkaat();
// luodaan kanta-asiakas Ville
        KantaAsiakas toka = new KantaAsiakas("Ville Vaara", 1980, "Mutalalantie 4, 80100 Joensuu", 123, "vaarala@gmail.com");
// kasvatetaan Villen ostosten summaa
        toka.lisaaOstosSummaan(100);
        toka.lisaaOstosSummaan(220.95);
// lisätään Villen tiedot kokoelmaan
        kauppa.lisaaAsiakas(toka);
// tulostetaan kanta-asiakkaat kokoelmasta
        kauppa.tulostaKantaAsiakkaat();
// tulostetaan kokoelmasta eniten ostoksia tehneen asiakkaan nimi
        System.out.println("Suurin asiakas " + kauppa.enitenOstoja());
// pyydetään kokoelmasta eniten ostoksia tehneen asiakkaan nimi ja haetaan nimen perusteella asiakkaan muut tiedot (oletus metodin toiminnalle: haetaan nimellä, jolla tiedot aina löytyvät)
        String nimi = kauppa.enitenOstoja();
        System.out.println(kauppa.getAsiakas(nimi));
    }
}