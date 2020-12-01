import java.util.Scanner;
import java.lang.Math;

/**
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class MathFunctions {

    public static long berechneTeilersumme(long zahl) {
        if (zahl <= 0)
            throw new IllegalArgumentException("Zahl darf nicht kleiner als 0 sein");

        long summe = 0;

        for (int i = 1; i <= zahl; i++) {
            if (zahl % i == 0) {
                summe = summe + i;
            }
        }
        return summe;
    }

    public static String berechneChecksummeIsbn(long isbn) {
        return "";
    }
}
