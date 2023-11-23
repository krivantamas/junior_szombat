package org.webler.zsolt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UtilitiesTest {


    private Utilities utilities;

    @BeforeAll
    public void init(){
        utilities = new Utilities();
    }

    @Test
    @DisplayName("Join words")
    public void testJoinWords(){

        String expected = "ovenvieraserious";

        String actual = utilities.joinWords("oven", "envier", "erase", "serious");

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Join words no cover")
    public void testJoinWords_2(){

        String expected = "aaabbbccc";

        String actual = utilities.joinWords("aaa", "bbb", "ccc");

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Join words empty words")
    public void testJoinWords_3(){

        String expected = "";

        String actual = utilities.joinWords("", "", "");

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Join words full cover")
    public void testJoinWords_4(){

        String expected = "oven";

        String actual = utilities.joinWords("oven", "oven", "oven");

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Join words")
    public void testJoinWords_5(){

        String expected = "kalacsalkusz";

        String actual = utilities.joinWords("kalacs", "alkusz");

        assertEquals(expected,actual);

    }

}
