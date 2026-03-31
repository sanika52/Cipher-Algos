import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VigenereCipherTest {

    // ----------------------------
    // Basic functionality tests
    // ----------------------------

    @Test
    public void testEncryptSimpleText() {
        assertEquals(
            "LXFOPVEFRNHR",
            VigenereCipher.encrypt("ATTACKATDAWN", "LEMON")
        );
    }

    @Test
    public void testDecryptSimpleText() {
        assertEquals(
            "ATTACKATDAWN",
            VigenereCipher.decrypt("LXFOPVEFRNHR", "LEMON")
        );
    }

    @Test
    public void testEncryptWithMixedCase() {
        assertEquals(
            "LxfopvEfRnhr",
            VigenereCipher.encrypt("AttackAtDawn", "LEMON")
        );
    }

    @Test
    public void testEncryptWithSpacesAndSymbols() {
        assertEquals(
            "Rijvs, Uyvjn!",
            VigenereCipher.encrypt("Hello, World!", "KEY")
        );
    }

    @Test
    public void testEncryptThenDecrypt() {
        String original = "JUnit makes testing fun!";
        String key = "VIGENERE";

        String encrypted = VigenereCipher.encrypt(original, key);
        String decrypted = VigenereCipher.decrypt(encrypted, key);

        assertEquals(original, decrypted);
    }

    @Test
    public void testEmptyString() {
        assertEquals("", VigenereCipher.encrypt("", "ABC"));
        assertEquals("", VigenereCipher.decrypt("", "ABC"));
    }

    // ----------------------------
    // Stronger Edge Case Tests
    // ----------------------------

    @Test
    public void testSingleCharacterInput() {
        assertEquals("L",
            VigenereCipher.encrypt("A", "LEMON"));
    }

    @Test
    public void testSingleCharacterKey() {
        assertEquals("BCD",
            VigenereCipher.encrypt("ABC", "B"));
    }

    @Test
    public void testKeyLongerThanText() {
        assertEquals("LXFOPV",
            VigenereCipher.encrypt("ATTACK", "LEMONLEMON"));
    }

    @Test
    public void testVeryLongInput() {
        String input = "A".repeat(1000);
        String encrypted = VigenereCipher.encrypt(input, "KEY");
        String decrypted = VigenereCipher.decrypt(encrypted, "KEY");

        assertEquals(input, decrypted);
    }

    @Test
    public void testTextWithOnlySymbols() {
        assertEquals("!@#$%^&*()",
            VigenereCipher.encrypt("!@#$%^&*()", "KEY"));
    }

    @Test
    public void testNumericInput() {
        assertEquals("12345",
            VigenereCipher.encrypt("12345", "KEY"));
    }

    @Test
    public void testLowercaseKey() {
        assertEquals("LXFOPVEFRNHR",
            VigenereCipher.encrypt("ATTACKATDAWN", "lemon"));
    }

    @Test
    public void testMixedAlphanumericText() {
        assertEquals("Rijvs123",
            VigenereCipher.encrypt("Hello123", "KEY"));
    }
}