import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FormularFakturaTest {

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
