public class Patient {

    private int patientNummer;
    private String name;

    public Patient(int patientNummer, String name) {
        if (patientNummer > 999 && patientNummer < 10000) {
            this.patientNummer = patientNummer;
        } else {
            throw new IllegalArgumentException("Patientennummer muss 4-stellig sein");
        }

        this.name = name;
    }

    public int getPatientNummer() {
        return patientNummer;
    }

    public void setPatientNummer(int patientNummer) {
        this.patientNummer = patientNummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getPatientNummer() + "      " + getName();
    }

}