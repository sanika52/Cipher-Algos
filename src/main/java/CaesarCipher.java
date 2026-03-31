class CaesarCipher {

    // Encryption function
    public static String encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch + s - 65) % 26 + 65));
            } 
            else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch + s - 97) % 26 + 97));
            } 
            else {
                result.append(ch); // special characters
            }
        }
        return result.toString();
    }

    // Decryption function
    public static String decrypt(String cipherText, int s) {
        return encrypt(cipherText, 26 - s);
    }
}
