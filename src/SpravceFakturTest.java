import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * Tato třída ověřuje, jestli se faktura správně přidá do seznamu.
 */
public class SpravceFakturTest {

    private SpravceFaktur spravce;
    private Faktura faktura;

    /**
     * Před každým testem vytvoří nového správce faktur a jednu testovací fakturu, která obsahuje jednoho klienta a jednu položku.
     */
    @BeforeEach
    public void setUp() {
        spravce = new SpravceFaktur();
        Klient klient = new Klient("Jan", "Dvorak", "Testovaci 12", "12345678", "777888999", "jan.dvorak@email.cz");
        faktura = new Faktura("F123", klient, new Date(), new Date(), "vystavitel@email.cz");

        PolozkaFaktury p = new PolozkaFaktury("Herní myš", 1, 299.0);
        faktura.pridatPolozku(p);
    }

    /**
     * Testuje, jestli se po přidání faktury správně zvýší počet faktur na 1 a ověřuje, že se do seznamu opravdu uložila faktura se zadaným číslem.
     */
    @Test
    public void testPridaniFaktury() {
        System.out.println("Test pro přidání faktury do seznamu");

        spravce.pridatFakturu(faktura);

        int pocet = spravce.pocetFaktur();
        String cisloFaktury = spravce.ziskejVsechnyFaktury().get(0).getCisloFaktury();

        System.out.println("Očekávaný počet faktur: 1");
        System.out.println("Skutečný počet faktur: " + pocet);
        System.out.println("Číslo uložené faktury: " + cisloFaktury);

        assertEquals(1, pocet);
        assertEquals("F123", cisloFaktury);
    }
}