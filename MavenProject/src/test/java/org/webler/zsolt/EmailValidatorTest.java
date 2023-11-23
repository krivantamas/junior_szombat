package org.webler.zsolt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {


    private EmailValidator emailValidator = new EmailValidator();

    @Test
    public void isValidTest_1() {
        String email = "nev@gmail.com";
        assertTrue(emailValidator.isValidEmail(email));
    }
    @Test
    public void isValidTest_2() {
        String email = "veZEtek.keresztnev999@domain.com";
        assertTrue(emailValidator.isValidEmail(email));
    }

    @Test
    public void isValidTest_3() {
        String email = "ez_is.helyes@gmail.hu";
        assertTrue(emailValidator.isValidEmail(email));
    }

    @Test
    public void isValidTest_4() {
        String email = "nevgmail.com";
        assertFalse(emailValidator.isValidEmail(email));
    }
    @Test
    public void isValidTest_5() {
        String email = "veZEtek.keresztnev999@domaincom";
        assertFalse(emailValidator.isValidEmail(email));
    }

    @Test
    public void isValidTest_6() {
        String email = "@gmail.hu";
        assertFalse(emailValidator.isValidEmail(email));
    }

    @Test
    public void isValidTest_7() {
        String email = "asdf@123.123";
        assertFalse(emailValidator.isValidEmail(email));
    }

    @Test
    public void isValidTest_8() {
        String email = "asdf@12345.co.uk";
        assertTrue(emailValidator.isValidEmail(email));
    }


}
