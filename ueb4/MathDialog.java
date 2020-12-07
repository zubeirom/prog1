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
    private static final int NULLSTELLENBERECHNEN = 3;
    private static final int SUMMEVONPOTENZEN = 4;

    private static final int ENDE = 0;

    /**
     * Einzelne befehle werden hier angezeigt
     * 
     * @return Ganzzahl eingabe des benutzer
     */

    private int einleseFunktion() {
        System.out.print(TEILSUMME + ": Teilsumme berechnen; " + CHECKSUMMEISBN + ": ISBN Checksumme berechnen; "
                + NULLSTELLENBERECHNEN + ": Nullstellen einer quadratische Gleichung berechnen : " + SUMMEVONPOTENZEN
                + " Summe Von Potenzen : " + ENDE + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier erhalten wird den Bestand
     * 
     * @return Ganzzahl eingabe vom benutzer
     */

    private long longEingabe() {
        return input.nextLong();
    }

    private double doubleEingabe() {
        return input.nextDouble();
    }

    private int intEingabe() {
        return input.nextInt();
    }

    /**
     * Hier wird abhängig vom benutzer die richtige methode ausgeführt
     * 
     * @param funktion Befehl des benutzer
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case TEILSUMME:
                System.out.println("Eingabe: ");
                long res1 = MathFunctions.berechneTeilersumme(longEingabe());
                System.out.println("Ergebnis: " + res1);
                break;
            case CHECKSUMMEISBN:
                System.out.println("Eingabe: ");
                String res2 = MathFunctions.berechneChecksummeIsbn(longEingabe());
                System.out.println("Ergebnis: " + res2);
                break;
            case NULLSTELLENBERECHNEN:
                System.out.println("Geben sie den ersten Wert: ");
                double val1 = doubleEingabe();
                System.out.println("Geben sie den zweiten Wert: ");
                double val2 = doubleEingabe();
                String res3 = MathFunctions.berechneNullstellen(val1, val2);
                System.out.println(res3);
                break;
            case SUMMEVONPOTENZEN:
                System.out.println("Eingabe: ");
                boolean res4 = MathFunctions.istSummeVonPotenzen(intEingabe());
                System.out.println("Ergebnis: " + res4);
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
