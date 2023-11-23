package org.webler.zsolt;

import java.util.Random;

public class PasswordGenerator {

    private static final Random RANDOM = new Random();

    public static final Character[] SPECIAL_CHARACTERS = new Character[]{'!', '_', '-', '?', '.', '#'};

    public static String generateWeakPassword(int passwordLength) {
        String password = "";

        while (password.length() < passwordLength) {
            password += (char) (RANDOM.nextInt(26) + 'a');
        }

        return password;
    }

    public static String generateAveragePassword(int passwordLength) {
        String password = "";
        while (password.length() < passwordLength) {
            if (password.length() % 2 == 0) {
                password += (char) (RANDOM.nextInt(26) + 'a');
            } else {
                password += (char) (RANDOM.nextInt(26) + 'A');
            }

        }

        return password;
    }

    public static String generateStrongPassword(int passwordLength) {
        String password = "";

        while (password.length() < passwordLength) {
            int modulo = password.length() % 3;
            if (modulo == 0) {
                password += (char) (RANDOM.nextInt(26) + 'a');
            } else if (modulo == 1) {
                password += (char) (RANDOM.nextInt(26) + 'A');
            } else {
                password += RANDOM.nextInt(10);
            }

        }
        return password;
    }

    public static String generateVeryStrongPassword(int passwordLength) {
        String password = "";


        while (password.length() < passwordLength) {
            int modulo = password.length() % 4;
            if (modulo == 0) {
                password += (char) (RANDOM.nextInt(26) + 'a');
            } else if (modulo == 1) {
                password += (char) (RANDOM.nextInt(26) + 'A');
            } else if (modulo == 2) {
                password += RANDOM.nextInt(10);
            } else {
                password += SPECIAL_CHARACTERS[RANDOM.nextInt(SPECIAL_CHARACTERS.length)];
            }

        }
        return password;
    }

}
