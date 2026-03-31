public class AtbashCipher {
    // Encrypts or decrypts text using Atbash Cipher
    public static String process(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) ('Z' - (ch - 'A')));
            } 
            else if (ch >= 'a' && ch <= 'z') {
                result.append((char) ('z' - (ch - 'a')));
            } 
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
