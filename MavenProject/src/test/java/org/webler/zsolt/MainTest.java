package org.webler.zsolt;

import org.junit.jupiter.api.*;

public class MainTest {

    @BeforeEach
    void init() {
        System.out.println("Init");
    }

    @AfterEach
    void cleanUp() {
        System.out.println("CleanUp");
    }

    @BeforeAll
    static void initAll() {
        System.out.println("initAll");
    }

    @AfterAll
    static void cleanUpAll() {
        System.out.println("cleanUpAll");
    }


    @Test
    @DisplayName("My Test")
    void myTestMethod() {
        System.out.println("MyTest");
    }

    @Test
    void testAlwaysTrueReturnsTrue(){
        boolean actual = Main.alwaysTrue();

        Assertions.assertTrue(actual);
    }

}
