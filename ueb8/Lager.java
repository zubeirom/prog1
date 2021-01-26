import java.util.Arrays;

/**
 * eine Klasse, die ein Lager für Artikel definiert
 * 
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class Lager {

    private Artikel[] lager;

    public Lager(int dimension) {
        if (dimension > 0) {
            this.lager = new Artikel[dimension];
        } else {
            throw new IllegalArgumentException("Dimension muss größer als null sein");
        }
    }

    public Lager() {
        this.lager = new Artikel[10];
    }

    public int getArtikelAnzahl() {
        int counter = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public int getLagerGroesse() {
        return lager.length;
    }

    public void legeAnArtikel(Artikel artikel) {
        int index = searchEmptySpace();
        if (index >= 0) {
            lager[index] = artikel;
        } else {
            throw new IndexOutOfBoundsException("Lager ist voll");
        }
    }

    public void entferneArtikel(int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (artikelNr == lager[i].getArtikelNr()) {
                lager[i] = null;
                break;
            }
        }
    }

    public void bucheZugang(int artikelNr, int menge) {
        Artikel artikel = filterNachArtikelnummer(artikelNr);
        if (artikel != null) {
            artikel.bucheZugang(menge);
        }
    }

    public void bucheAbgang(int artikelNr, int menge) {
        Artikel artikel = filterNachArtikelnummer(artikelNr);
        if (artikel != null) {
            artikel.bucheZugang(menge);
        } else {
            throw new NullPointerException("Artikel exestiert nicht");
        }
    }

    public void aenderePreisAllerArtikel(double prozent) {
        for (int i = 0; i < lager.length; i++) {
            double preis = lager[i].getPreis();
            double ergebnis = (5 / 100) * preis;
            lager[i].setPreis(preis + ergebnis);
        }
    }

    public Artikel getArtikel(int index) {
        if (index >= 0 && index < lager.length) {
            return lager[index];
        }
        throw new IndexOutOfBoundsException("Position exestiert nicht im Lager");
    }

    public String toString() {
        return Arrays.toString(lager);
    }

    private Artikel filterNachArtikelnummer(int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (artikelNr == lager[i].getArtikelNr()) {
                return lager[i];
            }
        }
        return null;
    }

    private int searchEmptySpace() {
        return Arrays.asList(lager).indexOf(null);
    }

}
