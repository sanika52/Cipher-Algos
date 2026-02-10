
import org.junit.Test;
import static org.junit.Assert.*;

public class RailFenceTest {

    // Test Encryption
    @Test
    public void testEncryptRailFence() {
        String text = "attack at once";
        int key = 2;

        String encrypted = RailFence.encryptRailFence(text, key);

        assertEquals("atc toctaka ne", encrypted);
    }

    // Test Decryption
    @Test
    public void testDecryptRailFence() {
        String cipher = "atc toctaka ne";
        int key = 2;

        String decrypted = RailFence.decryptRailFence(cipher, key);

        assertEquals("attack at once", decrypted);
    }

    //  Encrypt then Decrypt should give original text
    @Test
    public void testEncryptThenDecrypt() {
        String originalText = "GeeksforGeeks";
        int key = 3;

        String encrypted = RailFence.encryptRailFence(originalText, key);
        String decrypted = RailFence.decryptRailFence(encrypted, key);

        assertEquals(originalText, decrypted);
    }

    //  Test wrapper function (ENCRYPT)
    @Test
    public void testProcessRailFenceEncrypt() {
        String result = RailFence.processRailFence("HELLO", 2, true);

        assertTrue(result.contains("Operation : ENCRYPT"));
        assertTrue(result.contains("Input Text: HELLO"));
        assertTrue(result.contains("Key        : 2"));
    }

    //  Test wrapper function (DECRYPT)
    @Test
    public void testProcessRailFenceDecrypt() {
        String result = RailFence.processRailFence("HLOEL", 2, false);

        assertTrue(result.contains("Operation : DECRYPT"));
        assertTrue(result.contains("Input Text: HLOEL"));
        assertTrue(result.contains("Key        : 2"));
    }
}
