import java.io.*;
import java.util.ArrayList;

public class SpravceUzivatelu {

    private String nazevSouboru = "uzivatele.txt";

    public void ulozUzivatele(Uzivatel uzivatel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nazevSouboru, true));
            writer.write(
                    uzivatel.getJmeno() + "|" +
                            uzivatel.getPrijmeni() + "|" +
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

    public ArrayList<Uzivatel> nacistVsechnyUzivatele() {
        ArrayList<Uzivatel> uzivatele = new ArrayList<>();
        File soubor = new File(nazevSouboru);

        if (!soubor.exists()) {
            return uzivatele;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(nazevSouboru));
            String radek;

            while ((radek = reader.readLine()) != null) {
                String[] casti = radek.split("\\|");
                if (casti.length == 7) {
                    Uzivatel uzivatel = new Uzivatel(
                            casti[0],
                            casti[1],
                            casti[2],
                            casti[3],
                            casti[4],
                            casti[5],
                            casti[6]
                    );
                    uzivatele.add(uzivatel);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uzivatele;
    }

    public Uzivatel prihlas(String email, String heslo) {
        for (Uzivatel u : nacistVsechnyUzivatele()) {
            if (u.getEmail().equalsIgnoreCase(email) && u.jeSpravneHeslo(heslo)) {
                return u;
            }
        }
        return null;
    }
}
