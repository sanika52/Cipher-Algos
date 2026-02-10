import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CaesarCipherTest {

    @Test
    void testEncryptUppercase() {
        String result = CaesarCipher.encrypt("ABC", 3);
        assertEquals("DEF", result);
    }

    @Test
    void testEncryptLowercase() {
        String result = CaesarCipher.encrypt("abc", 3);
        assertEquals("def", result);
    }

    @Test
    void testEncryptMixedCase() {
        String result = CaesarCipher.encrypt("AbC", 3);
        assertEquals("DeF", result);
    }

    @Test
    void testEncryptWithSpaces() {
        String result = CaesarCipher.encrypt("Hello World", 3);
        assertEquals("Khoor Zruog", result);
    }

    @Test
    void testEncryptWithSpecialCharacters() {
        String result = CaesarCipher.encrypt("Hi! @123", 3);
        assertEquals("Kl! @123", result);
    }

    @Test
    void testDecrypt() {
        String result = CaesarCipher.decrypt("Khoor", 3);
        assertEquals("Hello", result);
    }

    @Test
    void testEncryptWithZeroShift() {
        String result = CaesarCipher.encrypt("Test", 0);
        assertEquals("Test", result);
    }
}
