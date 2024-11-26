package com.olechok;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCount {

    @Test
    void testCountUniqueCharacters_withDistinctCharacters() {
        String word = "abcdef";
        int expected = 6;
        int actual = com.olechok.Main.countUniqueCharacters(word);
        assertEquals(expected, actual);
    }

    @Test
    void testCountUniqueCharacters_withRepeatedCharacters() {
        String word = "hello";
        int expected = 4;
        int actual = com.olechok.Main.countUniqueCharacters(word);
        assertEquals(expected, actual);
    }

    @Test
    void testFindWordWithFewestUniqueChars_withDifferentWords() {
        String input = "apple banana cherry";
        String expected = "banana";
        String actual = com.olechok.Main.findWordWithFewestUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFindWordWithFewestUniqueChars_withTiedWords() {
        String input = "dog cat bat";
        String expected = "dog";
        String actual = com.olechok.Main.findWordWithFewestUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFindWordWithFewestUniqueChars_withSentence() {
        String input = "I love java?";
        String expected = "I";
        String actual = com.olechok.Main.findWordWithFewestUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFindWordWithFewestUniqueChars_withTwoSentence() {
        String input = "Who are you? My name is John Doe";
        String expected = "My";
        String actual = com.olechok.Main.findWordWithFewestUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFindWordWithFewestUniqueChars_withEmptyString() {
        String input = "";
        String expected = "";
        String actual = com.olechok.Main.findWordWithFewestUniqueChars(input);
        assertEquals(expected, actual);
    }
}
