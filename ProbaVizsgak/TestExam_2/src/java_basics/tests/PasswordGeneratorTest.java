package java_basics.tests;

import org.junit.jupiter.api.Test;
import java_basics.PasswordGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordGeneratorTest {

    @Test
    public void testWeakPasswordOnlyContainsLowercaseLetters() {

        List<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            validCharacters.add((char) ('a' + i));
        }

        String weakPassword = PasswordGenerator.generateWeakPassword(20);

        for (char c : weakPassword.toCharArray()) {
            assertTrue(validCharacters.contains(c));
        }


    }

    @Test
    public void testWeakPasswordLength() {

        String weakPassword = PasswordGenerator.generateWeakPassword(20);

        assertEquals(20, weakPassword.length());
    }

    @Test
    public void testAveragePasswordOnlyContainsLowercaseLetters() {

        List<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            validCharacters.add((char) ('a' + i));
            validCharacters.add((char) ('A' + i));
        }

        String averagePassword = PasswordGenerator.generateAveragePassword(20);

        for (char c : averagePassword.toCharArray()) {
            assertTrue(validCharacters.contains(c));
        }


    }

    @Test
    public void testAveragePasswordLength() {

        String averagePassword = PasswordGenerator.generateAveragePassword(20);

        assertEquals(20, averagePassword.length());
    }

}
