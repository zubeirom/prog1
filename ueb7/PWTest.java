public class PWTest {
    public static void main(String[] args) {
        try {
            // Warteschlange für maximal 10 Patienten anlegen
            PatientenWarteschlange pw = new PatientenWarteschlange(10);
            pw.neuerPatient(4711, "Löw, Jogi"); // Neuen Patient anfügen
            pw.neuerPatient(1234, "Kroos, Toni");
            pw.neuerPatient(1111, "Neuer, Manuel");
            pw.neuerPatient(2222, "Gnabry, Serge");
            System.out.println(pw); // Warteschlange ausgeben
            System.out.println(pw.entfernePatient(1234)); // Patient entfernen
            Patient naechster = pw.derNaechsteBitte(); // nächsten Patient herausholen
            System.out.println("Nächster Patient: " + naechster);
            System.out.println(pw);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
