import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
/**
 * Tato třída spravuje všechny faktury v programu.
 * Uchovává je v seznamu, umožňuje je přidat, získat a načíst ze souboru.
 */
public class SpravceFaktur {

    private ArrayList<Faktura> faktury;

    public SpravceFaktur() {
        faktury = new ArrayList<>();
    }

    /**
     * Přidává novou fakturu do seznamu.
     * Pokud je faktura null, vyhodí chybu.
     */
    public void pridatFakturu(Faktura faktura) {
        if (faktura == null) {
            throw new IllegalArgumentException("Faktura nesmí být null");
        } else {
            faktury.add(faktura);
        }
    }

    /**
     * Vrací faktury.
     * @return Vrací všechny faktury, které jsou momentálně uložené v seznamu.
     */
    public ArrayList<Faktura> ziskejVsechnyFaktury() {
        return new ArrayList<>(faktury);
    }

    /**
     * Vrací počet faktur.
     * @return Vrací počet faktur, které má správce momentálně uložené.
     */
    public int pocetFaktur() {
        return faktury.size();
    }

    /**
     * Načte faktury ze souboru podle e-mailu uživatele.
     * Pokud soubor neexistuje, metoda nic neudělá.
     * Všechny načtené faktury se uloží do seznamu, aby se s nimi mohlo později pracovat.
     */
    public void nacistFakturyZeSouboru(String emailUzivatele) {
        faktury.clear();
        String nazevSouboru = "faktury_" + emailUzivatele + ".txt";
        File soubor = new File(nazevSouboru);

        if (!soubor.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(soubor))) {
            String radek;

            while ((radek = reader.readLine()) != null) {
                String[] data = radek.split("\\|");

                if (data.length != 12) {
                    System.out.println("Přeskočeno, špatný počet údajů: " + radek);
                    continue;
                }

                String email = data[0];
                String cisloFaktury = data[1];
                long datumVystaveni = Long.parseLong(data[2]);
                long datumSplatnosti = Long.parseLong(data[3]);
                StavFaktury stav = StavFaktury.valueOf(data[4]);
                double castka = Double.parseDouble(data[5]);

                String jmenoKlienta = data[6];
                String prijmeniKlienta = data[7];
                String adresaKlienta = data[8];
                String icoKlienta = data[9];
                String telefonKlienta = data[10];
                String emailKlienta = data[11];

                Klient klient = new Klient(jmenoKlienta, prijmeniKlienta, adresaKlienta, icoKlienta, telefonKlienta, emailKlienta);

                Date vystaveni = new Date(datumVystaveni);
                Date splatnost = new Date(datumSplatnosti);

                Faktura faktura = new Faktura(cisloFaktury, klient, vystaveni, splatnost, email);
                faktura.setStavFaktury(stav);
                faktura.pridatPolozku(new PolozkaFaktury("Bez názvu", 1, castka));

                faktury.add(faktura);
            }

        } catch (Exception e) {
            System.out.println("Chyba při načítání faktur: " + e.getMessage());
        }
    }

}
