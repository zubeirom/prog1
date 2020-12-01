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

        Scanner input = new Scanner(System.in);
        System.out.println(" ** Teilersumme berechnen ** ");
        System.out.print(" geben Sie eine Zahl ein : ");
        zahl = input.nextLong();
        if (zahl <= 0)
            throw new IllegalArgumentException("Zahl darf nicht kleiner als 0 sein");

        long Summe = 0;

        for (int i = 1; i <= zahl; i++) {

            if (zahl % i == 0) {

                Summe = Summe + i;
            }

        }

        return Summe;
    }

    public static String berechneChecksummeIsbn() {
        long isbn;

        Scanner input = new Scanner(System.in);

        Long z1, z2, z3, z4, z5, z6, z7, z8, z9;

        System.out.println(" Isbn-Summe berechnen");

        System.out.print(" geben Sie Ihre erste Zahl ein: ");
        z1 = input.nextLong();
        if (z1 < 0)
            throw new IllegalArgumentException("z1 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre zweite Zahl ein: ");
        z2 = input.nextLong();
        if (z2 < 0)
            throw new IllegalArgumentException("z2 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre dritte Zahl ein: ");
        z3 = input.nextLong();
        if (z3 < 0)
            throw new IllegalArgumentException("z3 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre vierte Zahl ein: ");
        z4 = input.nextLong();
        if (z4 < 0)
            throw new IllegalArgumentException("z4 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre fünfte Zahl ein: ");
        z5 = input.nextLong();
        if (z5 < 0)
            throw new IllegalArgumentException("z5 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre sechste Zahl ein: ");
        z6 = input.nextLong();
        if (z6 < 0)
            throw new IllegalArgumentException("z6 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre siebte Zahl ein: ");
        z7 = input.nextLong();
        if (z7 < 0)
            throw new IllegalArgumentException("z7 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre achte Zahl ein: ");
        z8 = input.nextLong();
        if (z8 < 0)
            throw new IllegalArgumentException("z8 darf nicht kleiner als 0 sein");

        System.out.print(" geben Sie Ihre neunte Zahl ein: ");
        z9 = input.nextLong();
        if (z9 < 0)
            throw new IllegalArgumentException("z1 darf nicht kleiner als 0 sein");

        int zähler = 10;
        int iFaktor = 1;
        long summe = 0;
        long multiplikation = 0;
        String output = "";

        while (zähler != 9) {
            int i1 = iFaktor;
            int i2 = iFaktor + 1;
            int i3 = iFaktor + 2;
            int i4 = iFaktor + 3;
            int i5 = iFaktor + 4;
            int i6 = iFaktor + 5;
            int i7 = iFaktor + 6;
            int i8 = iFaktor + 7;
            int i9 = iFaktor + 8;

            multiplikation = (i1 * z1) + (i2 * z2) + (i3 * z3) + (i4 * z4) + (i5 * z5) + (i6 * z6) + (i7 * z7)
                    + (i8 * z8) + (i9 * z9);

            summe = multiplikation % 11;

            output = Long.toString(summe);

            zähler--;

            // System.out.println(multiplikation);

        }

        return output;

    }
}
