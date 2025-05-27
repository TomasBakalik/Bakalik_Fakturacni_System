import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.ArrayList;

/**
 * Tato třída testuje, jestli funguje uložení a načtení faktury ze souboru tak, jak by mělo.
 * Vytvoří se testovací faktura, uloží se do souboru a poté se zkusí znovu načíst.
 */
public class UlozeniANacteniFakturyTest {

    /**
     * Tento test ověřuje, že se faktura správně uloží do souboru a pak se načte zpět.
     * Kontrolují se hlavně tyto údaje: počet načtených faktur, číslo faktury, částka i stav zaplacení.
     */
    @Test
    public void testUlozeniANacteniFaktury() {
        System.out.println("Test pro uložení a načtení stejné faktury");

        String emailVystavitele = "test@seznam.cz";

        Klient klient = new Klient("Karel", "Novak", "Praha", "12345678", "777888999", "karel@seznam.cz");
        Faktura faktura = new Faktura("FINT001", klient, new Date(), new Date(), emailVystavitele);
        faktura.pridatPolozku(new PolozkaFaktury("Monitor", 1, 2999.0));
        faktura.setStavFaktury(StavFaktury.ZAPLACENA);

        UlozFaktury.ulozitFakturuProUzivatele(faktura, emailVystavitele);

        SpravceFaktur spravce = new SpravceFaktur();
        spravce.nacistFakturyZeSouboru(emailVystavitele);
        ArrayList<Faktura> faktury = spravce.ziskejVsechnyFaktury();

        System.out.println("Očekávaný počet načtených faktur: 1");
        System.out.println("Skutečný počet: " + faktury.size());

        assertFalse(faktury.isEmpty(), "Seznam načtených faktur by neměl být prázdný.");
        assertEquals(1, faktury.size(), "Měla by být načtena právě jedna faktura");

        System.out.println("Očekávané číslo faktury: FINT001");
        System.out.println("Skutečné číslo: " + faktury.get(0).getCisloFaktury());

        System.out.println("Očekávana částka: 2999.0");
        System.out.println("Skutečná částka: " + faktury.get(0).spocitejCelkovaCena());

        assertNotNull(faktury.get(0), "Načtená faktura nesmí být null.");
        assertEquals("FINT001", faktury.get(0).getCisloFaktury());
        assertEquals(2999.0, faktury.get(0).spocitejCelkovaCena());
        assertEquals(StavFaktury.ZAPLACENA, faktury.get(0).getStavFaktury());
        assertEquals("karel@seznam.cz", faktury.get(0).getKlient().getEmail());
    }
}
