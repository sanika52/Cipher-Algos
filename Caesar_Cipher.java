import java.util.Scanner;

class CaesarCipher {

    // Encrypts text using a shift of s
    public static String encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) ((ch + s - 65) % 26 + 65);
                result.append(encryptedChar);
            } 
            else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) ((ch + s - 97) % 26 + 97);
                result.append(encryptedChar);
            } 
            else {
                // For spaces or special characters
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Decrypts text using a shift of s
    public static String decrypt(String cipherText, int s) {
        return encrypt(cipherText, 26 - s);
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        System.out.print("Enter the shift value: ");
        int s = sc.nextInt();

        String encryptedText = encrypt(text, s);
        String decryptedText = decrypt(encryptedText, s);

        System.out.println("\nOriginal Text  : " + text);
        System.out.println("Encrypted Text : " + encryptedText);
        System.out.println("Decrypted Text : " + decryptedText);

        sc.close();
    }
}
