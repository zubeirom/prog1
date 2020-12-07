import java.lang.Math;

/**
 * 
 * Klasse die Mathefunktionen zum anwenden definiert
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public final class MathFunctions {

    /**
     * Durch die Methode wird die Teilsumme einer Zahl berechnet
     * 
     * @param zahl zahl zum berechnen der Teilsumme
     * 
     * @return Teilersumme
     */
    public static long berechneTeilersumme(long zahl) {

        long summe = 0;

        if (zahl <= 0) {
            throw new IllegalArgumentException("Zahl darf nicht kleiner als 0 oder 0 sein");
        }
        for (int i = 1; i <= zahl; i++) {
            if (zahl % i == 0) {
                summe = summe + i;
            }
        }
        return summe;

    }

    /**
     * Diese Methode gibt uns die Prüfziffer für eine ISBN
     * 
     * @param isbn Die ISBN's zum berechnen der prüfziffer
     * 
     * @return prüfZiffer des ISBN's
     */
    public static String berechneChecksummeIsbn(long isbn) {
        try {
            int prüfZiffer = 0;
            int summe = 0;
            String temp = Long.toString(isbn);

            if (isbn <= 0) {
                throw new IllegalArgumentException("ISBN darf nicht kleiner als 0 oder 0 sein");
            }

            if (temp.length() != 10 && temp.length() != 13) {
                throw new IllegalArgumentException("ISBN muss entweder 10 oder 13 ziffern haben sein");
            }

            /*
             * Schleife das die isbn eine ziffer nach dem anderen in die Rechnung
             * miteinbezieht
             */
            for (int i = 0; i < temp.length(); i++) {
                /*
                 * Nehmen die ziffer als char und konvertieren zu zahl damit wir berechnen
                 * können
                 */
                int product = (i + 1) * Character.getNumericValue(temp.charAt(i));
                summe += product;
            }

            prüfZiffer = summe % 11;

            /*
             * Ternary operator, falls prüfziffer 10 ist dann gebe X zurück ansonsten die
             * prüfziffer
             */
            return prüfZiffer == 10 ? Character.toString('X') : Integer.toString(prüfZiffer);

        } catch (Exception e) {
            throw e;
        }

    }

    /*
     * Eine Methode, die die Nullstellen einer quadratische Gleischung berechnet
     * 
     */
    public static String berechneNullstellen(double p, double q) {

        /*
         * Diskriminante SQRTdelta Nullstellen x1 , x 2
         */

        double Delta = (p * p) - (4 * q);

        double SQRTdelta = Math.sqrt(Delta);
        double x1 = ((-p) + SQRTdelta) / 2;
        double x2 = ((-p) - SQRTdelta) / 2;

        /*
         * Wir wollen zuerst annehmen, dass die werte komplexe nullstellen sind bis sie
         * durch die if-bedingungen geändert werden können.
         */

        String output = "Komplexe Nullstellen";

        /*
         * Fall-unterscheidung ob es zwei oder eine oder gar keine Nullstelle gibt
         *
         */
        if (SQRTdelta > 0) {
            output = "Zwei Nullstellen: " + x1 + " | " + x2;
        }

        if (SQRTdelta == 0) {
            output = "Doppelte Nullstelle " + x1;
        }

        return output;

    }

    /*
     * eine Methode die , die Summe von Potezen berechnet
     */
    public static boolean istSummeVonPotenzen(int n) {

        boolean entscheidung = false;

        for (int i = 1; i < 10001; i++) {

            /*
             * 3 zufallvariablen ,die von der Menge {1,2,3,4,5} in jedem Schreitt zufällig
             * gewählt werden.
             *
             * 
             * int zahl = (int) (Math.random()*x+y); x bedeutet von wie viel Zahlen wird die
             * zahl gewält y bedeutet ab welcher Zahl beginnt die Menge z.B. int a = (int)
             * (Math.random()*13+9) Unsere Menge => {9,10,11,12,13,14,15,.....}
             * 
             */
            int a = (int) (Math.random() * 5 + 1);
            int b = (int) (Math.random() * 5 + 1);
            int c = (int) (Math.random() * 5 + 1);

            int potenz_a = a * a * a * a;
            int potenz_b = b * b * b;
            int potenz_c = c * c;
            int summeP = potenz_a + potenz_b + potenz_c;

            if (n == summeP)
                entscheidung = true;

        }

        return entscheidung;
    }

}
