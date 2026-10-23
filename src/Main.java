
import java.time.Year;

class Bil {

    // Privata variabler
    private String märke;
    private String modell;
    private String registreringsnummer;
    private int årsmodell;
    private int hastighet;

    // Konstruktor
    public Bil(String registreringsnummer, String märke,
               String modell, int årsmodell) {

        if (märke == null || märke.isBlank()) {
            throw new IllegalArgumentException("Märke får inte vara tomt");
        }

        if (modell == null || modell.isBlank()) {
            throw new IllegalArgumentException("Modell får inte vara tom");
        }

        if (registreringsnummer == null || registreringsnummer.isBlank()) {
            throw new IllegalArgumentException("Registreringsnummer får inte vara tomt");
        }

        if (årsmodell < 1860 || årsmodell > Year.now().getValue()) {
            throw new IllegalArgumentException("Ogiltig årsmodell");
        }

        this.märke = märke;
        this.modell = modell;
        this.registreringsnummer = registreringsnummer;
        this.årsmodell = årsmodell;
        this.hastighet = 0;
    }

    // Getters
    public String getMärke() {
        return märke;
    }

    public String getModell() {
        return modell;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public int getÅrsmodell() {
        return årsmodell;
    }

    public int getHastighet() {
        return hastighet;
    }

    // Ändra modell
    public void setModell(String modell) {
        if (modell == null || modell.isBlank()) {
            throw new IllegalArgumentException("Modell får inte vara tom");
        }
        this.modell = modell;
    }

    // Öka hastigheten
    public void ökaHastighet(int ökning) {
        if (ökning <= 0) {
            throw new IllegalArgumentException("Ökningen måste vara större än 0");
        }

        hastighet += ökning;
    }

    // Bromsa bilen
    public void bromsa(int minskning) {
        if (minskning <= 0) {
            throw new IllegalArgumentException("Minskningen måste vara större än 0");
        }

        if (minskning > hastighet) {
            hastighet = 0;
        } else {
            hastighet -= minskning;
        }
    }

    // Skriver ut information om bilen
    @Override
    public String toString() {
        return "Registreringsnummer: " + registreringsnummer +
               "\nMärke: " + märke +
               "\nModell: " + modell +
               "\nÅrsmodell: " + årsmodell +
               "\nHastighet: " + hastighet + " km/h";
    }
}

// Huvudprogrammet
public class Main {

    public static void main(String[] args) {

        // Skapa en bil
        Bil bil1 = new Bil("ABC123", "Volvo", "V70", 2015);

        // Skriv ut bilens information
        System.out.println(bil1);

        // Öka hastigheten
        bil1.ökaHastighet(50);
        System.out.println("\nHastighet: " + bil1.getHastighet() + " km/h");

        // Bromsa bilen
        bil1.bromsa(20);
        System.out.println("Efter bromsning: " + bil1.getHastighet() + " km/h");

        // Ändra bilens modell
        bil1.setModell("XC60");
        System.out.println("Ny modell: " + bil1.getModell());

        // Visa bilens information igen
        System.out.println("\nUppdaterad information:");
        System.out.println(bil1);
    }
}