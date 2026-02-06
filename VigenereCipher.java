public class VigenereCipher {

    // Encrypt using Vigenere Cipher
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();

        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char base = isUpper ? 'A' : 'a';

                int textVal = ch - base;
                int keyVal = key.charAt(keyIndex % key.length()) - 'A';

                char encryptedChar =
                        (char) ((textVal + keyVal) % 26 + base);

                result.append(encryptedChar);
                keyIndex++;
            } else {
                result.append(ch); // keep spaces/special chars
            }
        }
        return result.toString();
    }

    // Decrypt using Vigenere Cipher
    public static String decrypt(String cipherText, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();

        int keyIndex = 0;

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);

            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char base = isUpper ? 'A' : 'a';

                int cipherVal = ch - base;
                int keyVal = key.charAt(keyIndex % key.length()) - 'A';

                char decryptedChar =
                        (char) ((cipherVal - keyVal + 26) % 26 + base);

                result.append(decryptedChar);
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
