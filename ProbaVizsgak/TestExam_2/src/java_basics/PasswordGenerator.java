package java_basics;

import java.util.Random;

public class PasswordGenerator {
    public static final char[] SPECIAL_CHARACTERS = new char[]{'!', '#', '$', '(', ')', '*', '+', '-', ',', '_', '/'};
    private static final Random RANDOM = new Random();

    public static String generateWeakPassword(int length) {

        StringBuilder password = new StringBuilder();
        while (password.length() < length - 1) {
            password.append((char) (RANDOM.nextInt(26) + 'a'));
        }

        return password.toString();

    }

    public static String generateAveragePassword(int length) {
        StringBuilder password = new StringBuilder();
        while (password.length() < length - 1) {
            if (RANDOM.nextBoolean()) {
                password.append((char) (RANDOM.nextInt(26) + 'a'));
            } else {
                password.append((char) (RANDOM.nextInt(26) + 'A'));
            }

        }

        return password.toString();
    }

    public static String generateStrongPassword(int length) {
        throw new UnsupportedOperationException();
    }

    public static String generateVeryStrongPassword(int length) {
        throw new UnsupportedOperationException();
    }

}
