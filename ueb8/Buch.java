public class Buch extends Artikel {
    private String titel;
    private String autor;
    private String verlag;

    public Buch(int artikelNr, double preis) {
        super(artikelNr, Artikel.MEDIEN, preis);
    }

    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
        super(artikelNr, Artikel.MEDIEN, preis);
        if (titel != null && !titel.trim().isEmpty()) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException("Titel muss angegeben werden");
        }
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("Autor muss angegeben werden");
        }
        if (verlag != null && !verlag.trim().isEmpty()) {
            this.verlag = verlag;
        } else {
            throw new IllegalArgumentException("Verlag muss angegeben werden");
        }
    }

    @Override
    String getBeschreibung() {
        return "autor : " + titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }
}
