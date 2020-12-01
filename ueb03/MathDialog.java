import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programm zum erstellen und bearbeiten von Artikeln
 * 
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class MathDialog {

    private Scanner input;

    public MathDialog() {
        input = new Scanner(System.in);
    }

    // Klassenkonstanten
    private static final int TEILSUMME = 1;
    private static final int CHECKSUMMEISBN = 2;
    private static final int ENDE = 0;

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.print(TEILSUMME + ": Teilsumme berechnen; " + CHECKSUMMEISBN + ": ISBN Checksumme berechnen; " + ENDE
                + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier erhalten wird den Bestand
     * 
     * @return Ganzzahl eingabe vom benutzer
     */

    private long longEingabe() {
        System.out.println("Eingabe: ");
        return input.nextLong();
    }

    /**
     * Hier wird abhängig vom benutzer die richtige methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case TEILSUMME:
                long res1 = MathFunctions.berechneTeilersumme(longEingabe());
                System.out.println("Ergebnis: " + res1);
                break;
            case CHECKSUMMEISBN:
                String res2 = MathFunctions.berechneChecksummeIsbn(longEingabe());
                System.out.println("Ergebnis: " + res2);
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
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einleseFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
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
        MathDialog mathDialog = new MathDialog();
        mathDialog.start();
    }
}
