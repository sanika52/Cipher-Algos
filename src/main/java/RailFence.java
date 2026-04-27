

import java.util.Arrays;

public class RailFence {

    // Encrypt function
    public static String encryptRailFence(String text, int key) {

        char[][] rail = new char[key][text.length()];

        for (int i = 0; i < key; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {

            if (row == 0 || row == key - 1)
                dirDown = !dirDown;

            rail[row][col++] = text.charAt(i);

            row += dirDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (rail[i][j] != '\n')
                    result.append(rail[i][j]);
            }
        }

        return result.toString();
    }

    // Decrypt function
    public static String decryptRailFence(String cipher, int key) {

        char[][] rail = new char[key][cipher.length()];

        for (int i = 0; i < key; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = true;
        int row = 0, col = 0;

        // Mark positions
        for (int i = 0; i < cipher.length(); i++) {

            if (row == 0)
                dirDown = true;
            if (row == key - 1)
                dirDown = false;

            rail[row][col++] = '*';

            row += dirDown ? 1 : -1;
        }

        // Fill cipher text
        int index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                if (rail[i][j] == '*' && index < cipher.length()) {
                    rail[i][j] = cipher.charAt(index++);
                }
            }
        }

        // Read zig-zag
        StringBuilder result = new StringBuilder();
        row = 0;
        col = 0;

        for (int i = 0; i < cipher.length(); i++) {

            if (row == 0)
                dirDown = true;
            if (row == key - 1)
                dirDown = false;

            result.append(rail[row][col++]);

            row += dirDown ? 1 : -1;
        }

        return result.toString();
    }

    // Wrapper function (called from main)
    public static String processRailFence(String text, int key, boolean encrypt ) {

        String output = encrypt
                ? encryptRailFence(text, key)
                : decryptRailFence(text, key);

        return "Operation : " + (encrypt ? "ENCRYPT" : "DECRYPT") + "\n"
             + "Input Text: " + text + "\n"
             + "Key        : " + key + "\n"
             + "Output     : " + output + "\n"
             + "------------------------------";
    }

    // // Main method
    // public static void main(String[] args) {

    //     // Encryption
    //     System.out.println(processRailFence("attack at once", 2, true));
    //     System.out.println(processRailFence("GeeksforGeeks", 3, true));

    //     // Decryption
    //     System.out.println(processRailFence("atc toctaka ne", 2, false));
    //     System.out.println(processRailFence("GsGsekfrek eoe", 3, false));
    // }
}

