import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tato třída testuje validaci e-mailu při vytváření klienta.
 * Ověřuje, jestli program správně rozpozná platné a neplatné e-maily.
 */
public class KlientTest {

    /**
     * Ověřuje, že při zadání neplatného e-mailu dojde k vyhození výjimky.
     * Zde zadaný e-mail nemá správný formát, takže by měl být odmítnut.
     */
    @Test
    public void testNeplatnyEmailVyhodiVyjimku() {
        System.out.println("Test pro neplatný e-mail");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Klient("Karel", "Svoboda", "Ulice 12", "12345678", "444555666", "neplatnyemail.cz");
        });

        System.out.println("Zadaný e-mail: neplatnyemail.cz");
        System.out.println("Výjimka: " + exception.getMessage());
    }

    /**
     * Ověřuje, že při zadání platného e-mailu se výjimka nevyhodí.
     * Program by měl klienta s tímto e-mailem bez problémů vytvořit.
     */
    @Test
    public void testPlatnyEmailNevyhodiVyjimku() {
        System.out.println("Test pro platný e-mail");

        assertDoesNotThrow(() -> {
            new Klient("Lucie", "Novotna", "Ulice 34", "87654321", "777888999", "lucie.novotna@seznam.cz");
        });

        System.out.println("Zadany e-mail: lucie.novotna@seznam.cz");
        System.out.println("Platný e-mail byl úspěšně přijat.");
    }
}