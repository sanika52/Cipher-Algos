import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CaesarCipherTest {

    @Test
    void testEncryptUppercase() {
        String result = CaesarCipher.encrypt("ABD", 3);
        assertEquals("DEG", result);
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

        @Test
    void testEncryptWithNegativeShift() {
        String result = CaesarCipher.encrypt("DEF", -3);
        assertEquals("ABC", result);
    }

    @Test
    void testEncryptWithLargeShift() {
        String result = CaesarCipher.encrypt("ABC", 29); // 29 = 3 mod 26
        assertEquals("DEF", result);
    }

    @Test
    void testEncryptWrapAroundUppercase() {
        String result = CaesarCipher.encrypt("XYZ", 3);
        assertEquals("ABC", result);
    }

    @Test
    void testEncryptWrapAroundLowercase() {
        String result = CaesarCipher.encrypt("xyz", 3);
        assertEquals("abc", result);
    }

    @Test
    void testEncryptFullAlphabet() {
        String result = CaesarCipher.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1);
        assertEquals("BCDEFGHIJKLMNOPQRSTUVWXYZA", result);
    }

    @Test
    void testEncryptEmptyString() {
        String result = CaesarCipher.encrypt("", 5);
        assertEquals("", result);
    }

    @Test
    void testDecryptWithDifferentShift() {
        String result = CaesarCipher.decrypt("Mjqqt", 5);
        assertEquals("Hello", result);
    }

    @Test
    void testEncryptWithShift26() {
        String result = CaesarCipher.encrypt("Hello", 26);
        assertEquals("Hello", result);
    }

    @Test
    void testEncryptWithShift52() {
        String result = CaesarCipher.encrypt("Hello", 52);
        assertEquals("Hello", result);
    }
}
