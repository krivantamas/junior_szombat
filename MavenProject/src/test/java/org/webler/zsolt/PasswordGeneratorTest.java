package org.webler.zsolt;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {


    @Test
    public void weakPasswordGeneratorLengthTest() {
        int expectedPasswordLength = 20;
        String weakPassword = PasswordGenerator.generateWeakPassword(expectedPasswordLength);
        assertEquals(expectedPasswordLength, weakPassword.length());
    }

    @Test
    public void averagePasswordGeneratorLengthTest() {
        int expectedPasswordLength = 20;
        String weakPassword = PasswordGenerator.generateAveragePassword(expectedPasswordLength);
        assertEquals(expectedPasswordLength, weakPassword.length());
    }

    @Test
    public void strongPasswordGeneratorLengthTest() {
        int expectedPasswordLength = 20;
        String weakPassword = PasswordGenerator.generateStrongPassword(expectedPasswordLength);
        assertEquals(expectedPasswordLength, weakPassword.length());
    }

    @Test
    public void veryStrongPasswordGeneratorLengthTest() {
        int expectedPasswordLength = 20;
        String weakPassword = PasswordGenerator.generateVeryStrongPassword(expectedPasswordLength);
        assertEquals(expectedPasswordLength, weakPassword.length());
    }

    @Test
    public void weakPasswordGeneratorContentTest() {
        int expectedPasswordLength = 20;
        String weakPassword = PasswordGenerator.generateWeakPassword(expectedPasswordLength);

        assertTrue(weakPassword.matches("^[a-z]+$"));
        assertTrue(weakPassword.toLowerCase().equals(weakPassword));
    }

    @Test
    public void averagePasswordGeneratorContentTest() {
        int expectedPasswordLength = 20;
        String averagePassword = PasswordGenerator.generateAveragePassword(expectedPasswordLength);

        assertTrue(averagePassword.matches("^[a-zA-Z]+$"));
        assertFalse(averagePassword.toLowerCase().equals(averagePassword));
    }

    @Test
    public void strongPasswordGeneratorContentTest() {
        int expectedPasswordLength = 20;
        String stongPassword = PasswordGenerator.generateAveragePassword(expectedPasswordLength);

        assertTrue(stongPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$"));
    }

    @Test
    public void veryPasswordGeneratorContentTest() {
        int expectedPasswordLength = 20;
        String strongPassword = PasswordGenerator.generateVeryStrongPassword(expectedPasswordLength);

        boolean containsLowerCase = false;
        boolean containsUpperCase = false;
        boolean containsNumber = false;
        boolean containsSpecialCharacter = false;


        for (char c : strongPassword.toCharArray()) {
            if (StringUtils.isNumeric(c + "")) {
                containsNumber = true;
            }
            if (StringUtils.isAllLowerCase(c + "")) {
                containsLowerCase = true;
            }
            if (StringUtils.isAllUpperCase(c + "")) {
                containsUpperCase = true;
            }
            if (Arrays.asList(PasswordGenerator.SPECIAL_CHARACTERS).contains(c)) {
                containsSpecialCharacter = true;
            }
        }




        assertTrue(containsNumber && containsLowerCase && containsUpperCase && containsSpecialCharacter);


    }


}
