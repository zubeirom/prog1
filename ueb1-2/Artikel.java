/**
 * eine Klasse, die einen Artikel, der 3 Attribute (artikelNr, art, bestand)
 * hat,nimmt.
 * 
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class Artikel {

    private int artikelNr;
    private String art;
    private int bestand;

    public Artikel(int artikelNr, String art, int bestand) {
        this.artikelNr = artikelNr;
        this.art = art;
        this.bestand = bestand;
    }

    public Artikel(int artikelNr, String art) {
        this.artikelNr = artikelNr;
        this.art = art;
    }

    /**
     * Mit der Methode bekommen wir die artikelNr
     * 
     * @return Artikelnummer
     */
    public int getArtikelNr() {
        return artikelNr;
    }

    /**
     * Mit der Methode bekommen wir die Art eines Artikel
     * 
     * @return Art des Artikels
     */
    public String getArt() {
        return art;
    }

    /**
     * Mit der Methode setzen wir eine neue Art für den Artikel
     * 
     * @param art Art des Artikels
     */
    public void setArt(String art) {
        this.art = art;
    }

    /**
     * Mit der Methode bekommen wir den Bestand des Artikels
     * 
     * @return Bestand des artikels
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * Setzen mit Methode den bestand neu
     * 
     * @param bestand Bestand des Artikels
     */
    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    /**
     * Mit der Methode wird dr Bestand um eine bestimmte Menge erhöht
     * 
     * @param menge Die menge die dazu addiert wird
     */
    public void bucheZugang(int menge) {
        this.bestand = bestand + menge;
    }

    /**
     * Mit der Methode wird der Bestand um eine bestimmte Menge vermindert
     * 
     * @param menge Die menge die den Bestand vermindert
     */
    public void bucheAbgang(int menge) {
        this.bestand = bestand - menge;
    }

    /**
     * Methode gibt Artikelnummer, Artikelart und Bestand zurück
     * 
     * @return Zeichenkette der Attribute artikelnr, art und bestand
     */
    public String toString() {
        return "Artikel: " + artikelNr + " Bezeichnung: " + art + " Bestand: " + bestand;
    }
}
