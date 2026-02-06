import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== CIPHER ALGORITHMS MENU =====");
            System.out.println("1. Atbash Cipher");
            System.out.println("2. Caesar Cipher");
            System.out.println("3. Rail Fence Cipher");
            System.out.println("4. Vigenere Cipher");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    // Atbash Cipher
                    System.out.print("Enter text: ");
                    String atbashText = sc.nextLine();

                    String atbashResult = AtbashCipher.process(atbashText);
                    System.out.println("Output: " + atbashResult);
                    break;

                case 2:
                    // Caesar Cipher
                    System.out.print("Enter text: ");
                    String caesarText = sc.nextLine();

                    System.out.print("Enter shift key: ");
                    int shift = sc.nextInt();
                    sc.nextLine();

                    System.out.print("1. Encrypt\n2. Decrypt\nChoose operation: ");
                    int caesarChoice = sc.nextInt();
                    sc.nextLine();

                    if (caesarChoice == 1) {
                        System.out.println("Encrypted Text: "
                                + CaesarCipher.encrypt(caesarText, shift));
                    } else if (caesarChoice == 2) {
                        System.out.println("Decrypted Text: "
                                + CaesarCipher.decrypt(caesarText, shift));
                    } else {
                        System.out.println("Invalid operation choice.");
                    }
                    break;

                case 3:
                    // Rail Fence Cipher
                    System.out.print("Enter text: ");
                    String railText = sc.nextLine();

                    System.out.print("Enter key (number of rails): ");
                    int key = sc.nextInt();
                    sc.nextLine();

                    System.out.print("1. Encrypt\n2. Decrypt\nChoose operation: ");
                    int railChoice = sc.nextInt();
                    sc.nextLine();

                    boolean encrypt = railChoice == 1;

                    System.out.println(
                            RailFence.processRailFence(railText, key, encrypt)
                    );
                    break;

                case 4:
                    // Vigenere Cipher
                    System.out.print("Enter text: ");
                    String vigText = sc.nextLine();

                    System.out.print("Enter key (word): ");
                    String vigKey = sc.nextLine();

                    System.out.print("1. Encrypt\n2. Decrypt\nChoose operation: ");
                    int vigChoice = sc.nextInt();
                    sc.nextLine();

                    if (vigChoice == 1) {
                        System.out.println("Encrypted Text: "
                                + VigenereCipher.encrypt(vigText, vigKey));
                    } else if (vigChoice == 2) {
                        System.out.println("Decrypted Text: "
                                + VigenereCipher.decrypt(vigText, vigKey));
                    } else {
                        System.out.println("Invalid operation choice.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
