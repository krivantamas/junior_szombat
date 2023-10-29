package org.webler.zsolt;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println(PasswordGenerator.generateWeakPassword(20));
        System.out.println(PasswordGenerator.generateAveragePassword(20));
        System.out.println(PasswordGenerator.generateStrongPassword(20));
        System.out.println(PasswordGenerator.generateVeryStrongPassword(20));
    }

    public static boolean alwaysTrue() {
        return true;
    }
}