public class Video extends Artikel {

    private String titel;
    private int spieldauer;
    private int jahr;

    public Video(int artikelNr, double preis) {
        super(artikelNr, Artikel.MEDIEN, preis);
    }

    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, Artikel.MEDIEN, preis);
        if (titel != null && !titel.trim().isEmpty()) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException("Titel muss angegeben werden");
        }
        if (spieldauer > 0) {
            this.spieldauer = spieldauer;
        } else {
            throw new IllegalArgumentException("Spieldauer muss größer als 0 sein");
        }
        if (jahr > 0) {
            this.jahr = jahr;
        } else {
            throw new IllegalArgumentException("Jahr muss größer als 0 sein");
        }
    }

    @Override
    String getBeschreibung() {
        return titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getSpieldauer() {
        return spieldauer;
    }

    public void setSpieldauer(int spieldauer) {
        this.spieldauer = spieldauer;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }
}
