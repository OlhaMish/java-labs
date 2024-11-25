package com.olechok;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LanguageDetectorTest {

    @Test
    public void testIsEnglishValid() {
        assertTrue(LanguageDetector.isEnglish("hello"));
        assertTrue(LanguageDetector.isEnglish("WORLD"));
        assertFalse(LanguageDetector.isEnglish("привіт"));
        assertFalse(LanguageDetector.isEnglish("123"));
        assertFalse(LanguageDetector.isEnglish("hello123"));
    }

    @Test
    public void testIsUkrainianValid() {
        assertTrue(LanguageDetector.isUkrainian("привіт"));
        assertTrue(LanguageDetector.isUkrainian("СВІТ"));
        assertFalse(LanguageDetector.isUkrainian("hello"));
        assertFalse(LanguageDetector.isUkrainian("123"));
        assertFalse(LanguageDetector.isUkrainian("привіт123"));
    }

    @Test
    public void testIsEnglishPhraseValid() {
        assertTrue(LanguageDetector.isEnglishPhrase("hello world"));
        assertTrue(LanguageDetector.isEnglishPhrase("HELLO WORLD"));
        assertFalse(LanguageDetector.isEnglishPhrase("hello привіт"));
        assertFalse(LanguageDetector.isEnglishPhrase("123"));
        assertFalse(LanguageDetector.isEnglishPhrase("hello 123"));
    }
}
