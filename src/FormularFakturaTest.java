import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tato třída testuje, jestli se správně generuje číslo faktury.
 */
public class FormularFakturaTest {

    /**
     * Tato metoda ověřuje že číslo faktury není null a má správný formát.
     * Je nutné, aby číslo začáínalo písmenem F a obsahovalo 14 číslic podle datumu a času.
     */
    @Test
    public void testGenerovaniCislaFaktury() {
        System.out.println("Test pro generování čísla faktury");

        FormularFaktura formular = new FormularFaktura(new SpravceFaktur());
        String cislo = formular.generujCisloFaktury();

        System.out.println("Vygenerované číslo faktury: " + cislo);

        assertNotNull(cislo, "Číslo faktury by nemělo být null.");
        assertTrue(cislo.matches("^F\\d{14}$"), "Číslo faktury by mělo začínat F a obsahovat 14 číslic.");
    }
}
