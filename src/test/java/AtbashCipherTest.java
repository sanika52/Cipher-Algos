import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AtbashCipherTest {

    // Test uppercase letters
    @Test
    void testUppercase() {
        String input = "ABCXYZ";
        String expected = "ZYXCBA";
        assertEquals(expected, AtbashCipher.process(input));
    }

    // Test lowercase letters
    @Test
    void testLowercase() {
        String input = "abcxyz";
        String expected = "zyxcba";
        assertEquals(expected, AtbashCipher.process(input));
    }

    // Test mixed case
    @Test
    void testMixedCase() {
        String input = "AbC";
        String expected = "ZyX";
        assertEquals(expected, AtbashCipher.process(input));
    }

    // Test numbers and symbols (should remain unchanged)
    @Test
    void testNonAlphabetCharacters() {
        String input = "Hello 123!";
        String expected = "Svool 123!";
        assertEquals(expected, AtbashCipher.process(input));
    }

    // Test empty string
    @Test
    void testEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, AtbashCipher.process(input));
    }

    // Test that encryption and decryption are same (Atbash property)
    @Test
    void testDoubleEncryptionReturnsOriginal() {
        String input = "HelloWorld";
        String encrypted = AtbashCipher.process(input);
        String decrypted = AtbashCipher.process(encrypted);
        assertEquals(input, decrypted);
    }
}
