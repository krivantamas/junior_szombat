package java_basics.tests;

import org.junit.jupiter.api.Test;
import java_basics.NamingConventionConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NamingConventionConverterTest {

    @Test
    public void testToSnakeCase_1() {
        String expected = "hello_world";
        String actual = NamingConventionConverter.toSnakeCase("hello world", false);

        assertEquals(expected, actual);
    }

    @Test
    public void testToSnakeCase_2() {
        String expected = "HELLO_WORLD";
        String actual = NamingConventionConverter.toSnakeCase("hello world", true);

        assertEquals(expected, actual);
    }

    @Test
    public void testToCamelCase() {
        String expected = "helloWorld";
        String actual = NamingConventionConverter.toCamelCase("hello world");

        assertEquals(expected, actual);
    }

    @Test
    public void testToKebabCase() {
        //TODO
        fail();
    }

    @Test
    public void testToPascalCase() {
       //TODO
        fail();
    }

}
