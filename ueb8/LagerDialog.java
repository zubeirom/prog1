import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programm zum testen von Lager
 * 
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class LagerDialog {

    Lager lager;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int ARTIKELANLEGEN = 1;
    private static final int ZUGANGBUCHEN = 2;
    private static final int ABGANGBUCHEN = 3;
    private static final int LAGERGROESSE = 5;
    private static final int ENTFERNEARTIKEL = 8;
    private static final int PREISEBEARBEITEN = 9;
    private static final int LAGERINHALT = 10;
    private static final int LAGERANLEGEN = 11;
    private static final int ARTIKELANZAHL = 12;
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

    private Lager lagerAnlegen() {
        input.nextLine();
        System.out.println("Lagergrösse (Drücke Enter um Standardgröße 10 zu verwenden): ");
        String eingabe = input.nextLine();
        int größe = eingabe.isEmpty() ? 10 : Integer.parseInt(eingabe);
        return new Lager(größe);
    }

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.println("--------- Lager System ---------");
        System.out.print(ARTIKELANLEGEN + ": Artikel anlegen; \n" + ZUGANGBUCHEN + ": Bestand des artikels erhöhen; \n"
                + ABGANGBUCHEN + ": Bestand des Artikels verringern; \n" + LAGERGROESSE + ": Lagergrösse anzeigen; \n"
                + ENTFERNEARTIKEL + ": Entferne artikel; \n" + PREISEBEARBEITEN + ": Preise nach prozen bearbeiten; \n"
                + LAGERINHALT + ": Inhalt des Lagers aufzeigen; \n" + LAGERANLEGEN + ": Lager anlegen; \n"
                + ARTIKELANZAHL + ": Artikel anzahl; \n" + ENDE + ": beenden -> ");
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
            case LAGERANLEGEN:
                lager = lagerAnlegen();
                break;
            case ARTIKELANLEGEN:
                Artikel artikel = artikelAnlegen();
                lager.legeAnArtikel(artikel);
                break;
            case ZUGANGBUCHEN:
                System.out.println("Artikelnummer: ");
                int artikelNr = input.nextInt();
                lager.bucheZugang(artikelNr, bestandEingabe());
                break;
            case ABGANGBUCHEN:
                System.out.println("Artikelnummer: ");
                int artikelNr1 = input.nextInt();
                lager.bucheZugang(artikelNr1, bestandEingabe());
                break;
            case LAGERGROESSE:
                System.out.println("Die Lagergrösse ist " + lager.getLagerGroesse());
                break;
            case ENTFERNEARTIKEL:
                System.out.println("Artikelnummer: ");
                int artikelNr2 = input.nextInt();
                lager.entferneArtikel(artikelNr2);
                break;
            case PREISEBEARBEITEN:
                System.out.println("Prozent: ");
                Double prozent = input.nextDouble();
                lager.aenderePreisAllerArtikel(prozent);
                break;
            case ARTIKELANZAHL:
                System.out.println("Die Artikelanzahl lautet " + lager.getArtikelAnzahl());
                break;
            case LAGERINHALT:
                System.out.println(lager.toString());
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
        lager = null;
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einleseFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("Lager oder Artikel exestiert nicht! Bitte erstellen sie diese zuerst.");
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
        new LagerDialog().start();
    }
}
