import java.io.*;
import java.util.ArrayList;

/**
 * Tato třída slouží k práci s uživateli.
 * Umožňuje ukládat nové uživatele do souboru, načítat je zpět a ověřovat jejich přihlášení podle e-mailu a hesla.
 */
public class SpravceUzivatelu {

    private String nazevSouboru = "uzivatele.txt";

    /**
     * Ukládá uživatele do txt souboru.
     * Údaje jsou oddělené znakem | a zapisují se na nový řádek.
     * @param uzivatel Uživatel, který se má uložit.
     */
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

    /**
     * Načte všechny uživatele ze souboru a vrátí je jako array list.
     * Každý uživatel musí mít správně vyplněných 7 údajů.
     * Pokud soubor neexistuje vrací se prázdný seznam.
     * @return Vrací seznam uživatelů.
     */
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

    /**
     * Hledá uživatele podle zadaného emailu a hesla.
     * @param email E-mail zadaný při přihlášení.
     * @param heslo Heslo zadané při přihlášení.
     * @return Když najde uživatele, vrátí ho, když ne, vrátí null.
     */
    public Uzivatel prihlas(String email, String heslo) {
        for (Uzivatel u : nacistVsechnyUzivatele()) {
            if (u.getEmail().equalsIgnoreCase(email) && u.jeSpravneHeslo(heslo)) {
                return u;
            }
        }
        return null;
    }
}
