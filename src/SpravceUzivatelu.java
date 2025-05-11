import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SpravceUzivatelu {

    private String nazevSouboru = "uzivatele.txt";

    public void ulozUzivatele(Uzivatel uzivatel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nazevSouboru, true));
            writer.write(
                    uzivatel.getJmeno() + "|" +
                            uzivatel.getPrijemni() + "|" +
                            uzivatel.getEmail() + "|" +
                            uzivatel.getHeslo() + "|" +
                            uzivatel.getTelefon() + "|" +
                            uzivatel.getIdUzivatele() + "|" +
                            uzivatel.getAdresa()
            );
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
