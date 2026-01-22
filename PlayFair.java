import java.util.*;

public class PlayFair {

    private char[][] matrix = new char[5][5];
    private Map<Character, int[]> positionMap = new HashMap<>();

    // Constructor
    public PlayFair(String key) {
        generateMatrix(key);
    }

    // Generate Playfair Matrix
    private void generateMatrix(String key) {
        boolean[] used = new boolean[26];
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        StringBuilder sb = new StringBuilder();

        // Add key characters
        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                sb.append(c);
                used[c - 'A'] = true;
            }
        }

        // Add remaining alphabets
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;
            if (!used[c - 'A']) {
                sb.append(c);
                used[c - 'A'] = true;
            }
        }

        // Fill matrix
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sb.charAt(index);
                positionMap.put(matrix[i][j], new int[]{i, j});
                index++;
            }
        }
    }

    // Prepare text
    private String prepareText(String text, boolean encrypt) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        if (!encrypt) return text;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char first = text.charAt(i);
            char second = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X';

            if (first == second) {
                result.append(first).append('X');
            } else {
                result.append(first).append(second);
                i++;
            }
        }

        if (result.length() % 2 != 0) {
            result.append('X');
        }

        return result.toString();
    }

    // Encrypt
    public String encrypt(String plaintext) {
        plaintext = prepareText(plaintext, true);
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            char a = plaintext.charAt(i);
            char b = plaintext.charAt(i + 1);

            int[] posA = positionMap.get(a);
            int[] posB = positionMap.get(b);

            if (posA[0] == posB[0]) { // Same row
                cipher.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                cipher.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                cipher.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                cipher.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else { // Rectangle
                cipher.append(matrix[posA[0]][posB[1]]);
                cipher.append(matrix[posB[0]][posA[1]]);
            }
        }
        return cipher.toString();
    }

    // Decrypt
    public String decrypt(String ciphertext) {
        ciphertext = prepareText(ciphertext, false);
        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);

            int[] posA = positionMap.get(a);
            int[] posB = positionMap.get(b);

            if (posA[0] == posB[0]) { // Same row
                plain.append(matrix[posA[0]][(posA[1] + 4) % 5]);
                plain.append(matrix[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                plain.append(matrix[(posA[0] + 4) % 5][posA[1]]);
                plain.append(matrix[(posB[0] + 4) % 5][posB[1]]);
            } else { // Rectangle
                plain.append(matrix[posA[0]][posB[1]]);
                plain.append(matrix[posB[0]][posA[1]]);
            }
        }
        return plain.toString();
    }

    // Display Matrix
    public void displayMatrix() {
        System.out.println("\nPlayfair Matrix:");
        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Key: ");
        String key = sc.nextLine();

        PlayFair cipher = new PlayFair(key);
        cipher.displayMatrix();

        System.out.println("\nChoose Operation:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Enter choice (1/2): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            System.out.print("Enter Plaintext: ");
            String plaintext = sc.nextLine();
            System.out.println("Encrypted Text: " + cipher.encrypt(plaintext));
        } 
        else if (choice == 2) {
            System.out.print("Enter Ciphertext: ");
            String ciphertext = sc.nextLine();
            System.out.println("Decrypted Text: " + cipher.decrypt(ciphertext));
        } 
        else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
