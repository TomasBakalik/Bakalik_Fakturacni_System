import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UlozFaktury {

    public static void ulozitFakturuProUzivatele(Faktura faktura, String emailVystavitele) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("faktury_" + emailVystavitele + ".txt", true))) {
            Klient k = faktura.getKlient();
            writer.write(
                    emailVystavitele + "|" +
                            faktura.getCisloFaktury() + "|" +
                            faktura.getDatumVystaveni().getTime() + "|" +
                            faktura.getDatumSplatnosti().getTime() + "|" +
                            faktura.getStavFaktury().name() + "|" +
                            faktura.spocitejCelkovaCena() + "|" +
                            k.getJmeno() + "|" +
                            k.getPrijemni() + "|" +
                            k.getAdresa() + "|" +
                            k.getIco() + "|" +
                            k.getTelefonniCislo() + "|" +
                            k.getEmail()
            );
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Chyba pri ukladani faktury uzivatele: " + e.getMessage());
        }
    }
}
