import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programm zum erstellen und bearbeiten von Artikeln
 * 
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class ArtikelDialog {

    private Artikel artikel1;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int ANLEGEN = 1;
    private static final int ZUGANGBUCHEN = 2;
    private static final int ABGANGBUCHEN = 3;
    private static final int ARTIKELARTNEUSETZEN = 4;
    private static final int ARTIKELINFOS = 5;
    private static final int ENDE = 0;

    /**
     * Hier wird eine neues Artikel angelegt
     * 
     * @return neues Artikel
     */

    private Artikel artikelAnlegen() {
        System.out.print("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();
        System.out.println("Artikelart: ");
        String art = input.nextLine().trim();
        System.out.print("Preis: ");
        double preis = input.nextDouble();
        input.nextLine();
        System.out.println("Bestand (Drücke Enter, falls nicht vorhanden): ");
        String eingabe = input.nextLine();
        int bestand = eingabe.isEmpty() ? 0 : Integer.parseInt(eingabe);
        if (bestand < 1) {
            return new Artikel(artikelNr, art, preis);
        }
        return new Artikel(artikelNr, art, bestand, preis);
    }

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.println("--------- Artikel Konfiguration ---------");
        System.out.print(
                ANLEGEN + ": Artikel anlegen; " + ZUGANGBUCHEN + ": Bestand des artikels erhöhen; " + ABGANGBUCHEN
                        + ": Bestand des Artikels verringern; " + ARTIKELARTNEUSETZEN + ": Artikelart neu setzen; "
                        + ARTIKELINFOS + ": Artikelinformationen erhalten; " + ENDE + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier erhalten wird den Bestand
     * 
     * @return Ganzzahl eingabe vom benutzer
     */

    private int bestandEingabe() {
        System.out.println("Bestand: ");
        return input.nextInt();
    }

    /**
     * 
     * Hier wird die artikelart als eingabe vom benutzer übergeben
     * 
     * @return Zeile der benutzereingabe
     */
    private String artEingabe() {
        input.nextLine();
        System.out.println("Artikelart: ");
        return input.nextLine();
    }

    /**
     * Hier wird abhängig vom benutzer die richtige artikel methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case ANLEGEN:
                artikel1 = artikelAnlegen();
                artikel1.toString();
                break;
            case ZUGANGBUCHEN:
                artikel1.bucheZugang(bestandEingabe());
                break;
            case ABGANGBUCHEN:
                artikel1.bucheAbgang(bestandEingabe());
                break;
            case ARTIKELARTNEUSETZEN:
                artikel1.setArt(artEingabe());
                break;
            case ARTIKELINFOS:
                System.out.println(artikel1.toString());
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Funktion!");
                break;
        }
    }

    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        artikel1 = null;
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einleseFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("Artikel exestiert nicht! Bitte erstellen sie zuerst ein Artikel.");
            } catch (InputMismatchException e) {
                System.out.println(e + " Falsche Eingabe!");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e + " Programm beendet");
                funktion = ENDE;
            }
        }
    }

    /**
     * Main methode
     * 
     * @param args
     */

    public static void main(String[] args) {
        // new ArtikelDialog().start();

        Artikel[] a = new Artikel[] { new Artikel(1323, "cd", 1.1), new Artikel(1322, "cd", 1.1),
                new Artikel(1323, "cd", 1.1) };
        System.out.println(Arrays.toString(a));
    }
}
