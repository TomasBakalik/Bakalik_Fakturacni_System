import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tato třída slouží k uložení faktury do souboru podle přihlášeného uživatele.
 * Vytvoří soubor, který je nazván podle e-mailu uživatele a do něj zapisuje vystavené faktury.
 */
public class UlozFaktury {

    /**
     * Metoda, která uloží jednu fakturu do souboru daného uživatele podle jeho e-mailu.
     * Data o faktuře a klientovi se zapíší do textového souboru ve formátu odděleném znakem |.
     * Pokud dojde k chybě při ukládání, vypíše se chybová zpráva do konzole.
     * @param faktura Faktura, která se má uložit
     * @param emailVystavitele E-mail přihlášeného uživatele, podle kterého se soubor jmenuje
     */
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
                            k.getPrijmeni() + "|" +
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
