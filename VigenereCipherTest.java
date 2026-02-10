import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VigenereCipherTest {

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
}

