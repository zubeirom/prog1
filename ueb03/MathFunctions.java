/**
 * Math funktionen klasse die einmal teilersumme berechnet und prüfziffer einer
 * isbn berechnet
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
        try {
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

        } catch (Exception e) {
            throw e;
        }
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
}
