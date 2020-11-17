
/**
 * eine Klasse, die einen Artikel, der 3 Attribute (artikelNr, art, bestand)
 * hat,nimmt.
 * 
 * 
 *
 * @author (Mouayad Haji Omar, Zubeir Mohamed)
 * @version
 */
public class Artikel {

    public int artikelNr;
    public String art;
    public int bestand;

    public Artikel(int artikelNr, String art, int bestand) {
        this.artikelNr = artikelNr;
        this.art = art;
        this.bestand = bestand;
    }

    // Mit der Methode "getArtikelNr" wird die ArtikelNr auf der Konsole
    // erschienen
    public int getArtikelNr() {
        return artikelNr;
    }

    // Mit der Methode "setArtikelNr" wird eine neue ArtikelNrdie statt
    // der alten ArtikelNr auf der Konsole erschienen
    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    // Mit der Methode "buchZugang" wird
    // den Bestand um eine bestimmte Menge erhöht.
    public void bucheZugang(int menge) {
        this.bestand = bestand + menge;
    }

    // Mit der Methode "buchZugang" wird
    // den Bestand um eine bestimmte Menge vermindert.
    public void bucheAbgang(int menge) {
        this.bestand = bestand - menge;

    }

    // Mit der Methode "toString" wird
    // ein Artikel-Objekt als Zeichenkette aufbereitet.
    public String toString() {
        return artikelNr + " " + art + " " + bestand;
    }

    public void print() {
        System.out.println("Artikelnummer = " + artikelNr);
        System.out.println("Bezeichnung = " + art);
        System.out.println("Bestand = " + bestand);
    }

}
