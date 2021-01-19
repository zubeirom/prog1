import java.util.AbstractMap.SimpleEntry;

public class PatientenWarteschlange {

    Patient[] patientenWarteschlange;

    public PatientenWarteschlange(int größe) {
        this.patientenWarteschlange = new Patient[größe];
    }

    public void neuerPatient(int pnr, String name) {
        int index = suchePlatz();

        if (findByPnr(pnr) != null) {
            throw new IllegalArgumentException("Patientennummer exestiert schon!");
        }
        if (index >= 0) {
            patientenWarteschlange[index] = new Patient(pnr, name);
        } else {
            throw new IndexOutOfBoundsException("Warteschlange ist voll!");
        }
    }

    public String entfernePatient(int pnr) {
        SimpleEntry<Patient, Integer> patientInfo = findByPnr(pnr);
        if (patientInfo == null) {
            throw new NullPointerException("Patient exestiert nicht");
        }
        patientenWarteschlange[patientInfo.getValue()] = null;
        formatList();
        return "Patient gelöscht: " + patientInfo.getKey().getPatientNummer() + "      "
                + patientInfo.getKey().getName();
    }

    public Patient derNaechsteBitte() {
        Patient naechsterPatient = patientenWarteschlange[0];
        entfernePatient(naechsterPatient.getPatientNummer());
        return naechsterPatient;
    }

    private int suchePlatz() {
        for (int i = 0; i < patientenWarteschlange.length; i++) {
            if (patientenWarteschlange[i] == null) {
                return i;
            }
        }

        return -1;
    }

    private void formatList() {
        for (int i = 0; i < patientenWarteschlange.length; i++) {
            if (i < patientenWarteschlange.length - 2 && patientenWarteschlange[i] == null
                    && patientenWarteschlange[i + 1] != null) {
                patientenWarteschlange[i] = patientenWarteschlange[i + 1];
                patientenWarteschlange[i + 1] = null;
            }
        }
    }

    private SimpleEntry<Patient, Integer> findByPnr(int pnr) {
        for (int i = 0; i < patientenWarteschlange.length; i++) {
            if (patientenWarteschlange[i] != null && patientenWarteschlange[i].getPatientNummer() == pnr) {
                return new SimpleEntry<Patient, Integer>(patientenWarteschlange[i], i);
            }
        }

        return null;
    }

    public String toString() {

        String concatList = new String();

        for (int i = 0; i < patientenWarteschlange.length; i++) {
            if (patientenWarteschlange[i] != null) {
                concatList += patientenWarteschlange[i].getPatientNummer() + "    "
                        + patientenWarteschlange[i].getName() + "\n";
            }

        }

        return "\nWarteliste\n" + "Pnr     Name\n" + concatList;
    }

}
