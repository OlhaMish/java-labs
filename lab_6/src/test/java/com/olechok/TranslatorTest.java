package com.olechok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {
    private Translator translator;

    @BeforeEach
    public void setUp() {
        translator = new Translator();
    }

    @Test
    public void testAddWordAndTranslatePhrase() {
        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");

        String phrase = "hello world";
        String translatedPhrase = translator.translatePhrase(phrase);

        assertEquals("привіт світ", translatedPhrase);
    }

    @Test
    public void testTranslatePhraseWithUnknownWords() {
        translator.addWord("hello", "привіт");

        String phrase = "hello universe";
        String translatedPhrase = translator.translatePhrase(phrase);

        assertEquals("привіт [universe]", translatedPhrase);
    }

    @Test
    public void testTranslateEmptyPhrase() {
        String phrase = "";
        String translatedPhrase = translator.translatePhrase(phrase);

        assertEquals("[]", translatedPhrase);
    }

    @Test
    public void testTranslatePhraseCaseInsensitive() {
        translator.addWord("Hello", "Привіт");
        translator.addWord("WORLD", "Світ");

        String phrase = "HELLO world";
        String translatedPhrase = translator.translatePhrase(phrase);

        assertEquals("привіт світ", translatedPhrase);
    }
}

