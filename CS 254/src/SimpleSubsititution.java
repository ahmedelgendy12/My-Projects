import java.util.Scanner;

public class SimpleSubsititution {
        private static final int ALPHABET_LENGTH = 26;
        private static final int SHIFT = 3;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message to encrypt: ");
            String message = sc.nextLine();
            String encrypted = encrypt(message);
            System.out.println("Encrypted message: " + encrypted);
            String decrypted = decrypt(encrypted);
            System.out.println("Decrypted message: " + decrypted);
        }

        private static String encrypt(String message) {
            char[] chars = message.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (Character.isLowerCase(c)) {
                    int index = (c - 'a' + SHIFT) % ALPHABET_LENGTH;
                    chars[i] = (char) ('a' + index);
                }
            }
            return new String(chars);
        }

        private static String decrypt(String encrypted) {
            char[] chars = encrypted.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (Character.isLowerCase(c)) {
                    int index = (c - 'a' - SHIFT + ALPHABET_LENGTH) % ALPHABET_LENGTH;
                    chars[i] = (char) ('a' + index);
                }
            }
            return new String(chars);
        }
    }
