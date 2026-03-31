import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RailFenceTest {

    @Test
    void testEncryptRailFence() {
        String encrypted = RailFence.encryptRailFence("attack at once", 2);
        assertEquals("atc toctaka ne", encrypted);
    }

    @Test
    void testDecryptRailFence() {
        String decrypted = RailFence.decryptRailFence("atc toctaka ne", 2);
        assertEquals("attack at once", decrypted);
    }

    @Test
    void testEncryptThenDecrypt() {
        String originalText = "GeeksforGeeks";
        String encrypted = RailFence.encryptRailFence(originalText, 3);
        String decrypted = RailFence.decryptRailFence(encrypted, 3);
        assertEquals(originalText, decrypted);
    }

    @Test
    void testProcessRailFenceEncrypt() {
        String result = RailFence.processRailFence("HELLO", 2, true);

        assertTrue(result.contains("Operation : ENCRYPT"));
        assertTrue(result.contains("Input Text: HELLO"));
        assertTrue(result.contains("Key        : 2"));
    }

    @Test
    void testProcessRailFenceDecrypt() {
        String result = RailFence.processRailFence("HLOEL", 2, false);

        assertTrue(result.contains("Operation : DECRYPT"));
        assertTrue(result.contains("Input Text: HLOEL"));
        assertTrue(result.contains("Key        : 2"));
    }

    @Test
    void testLongerString() {
        assertEquals("RFEHALECCPEINIR", RailFence.encryptRailFence("RAILFENCECIPHER", 3));
    }
}