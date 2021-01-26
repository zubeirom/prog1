public class CD extends Artikel {

    private String interpret;
    private String titel;
    private int anzahlTitel;

    public CD(int artikelNr, double preis) {
        super(artikelNr, Artikel.MEDIEN, preis);
    }

    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, Artikel.MEDIEN, preis);
        if (titel != null && !titel.trim().isEmpty()) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException("Titel muss angegeben werden");
        }
        if (interpret != null && !interpret.trim().isEmpty()) {
            this.interpret = interpret;
        } else {
            throw new IllegalArgumentException("Interpret muss angegeben werden");
        }
        if (anzahlTitel > 0) {
            this.anzahlTitel = anzahlTitel;
        } else {
            throw new IllegalArgumentException("Titelanzahl muss 0 sein");
        }
    }

    @Override
    String getBeschreibung() {
        return "interpret : " + titel;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getAnzahlTitel() {
        return anzahlTitel;
    }

    public void setAnzahlTitel(int anzahlTitel) {
        this.anzahlTitel = anzahlTitel;
    }

}
