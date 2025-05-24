import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class KlientTest {

    @Test
    public void testNeplatnyEmailVyhodiVyjimku() {
        System.out.println("Test pro neplatný e-mail");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Klient("Karel", "Svoboda", "Ulice 12", "12345678", "444555666", "neplatnyemail.cz");
        });

        System.out.println("Zadaný e-mail: neplatnyemail.cz");
        System.out.println("Výjimka: " + exception.getMessage());
    }

    @Test
    public void testPlatnyEmailNevyhodiVyjimku() {
        System.out.println("Test pro platný e-mail");

        assertDoesNotThrow(() -> {
            new Klient("Lucie", "Novotna", "Ulice 34", "87654321", "777888999", "lucie.novotna@seznam.cz");
        });

        System.out.println("Zadany e-mail: lucie.novotna.cz");
        System.out.println("Platný e-mail byl úspěšně přijat.");
    }
}