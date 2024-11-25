package com.olechok;

public class LanguageDetector {
    public static boolean isEnglish(String word) {
        return word.matches("[a-zA-Z]+");
    }

    public static boolean isUkrainian(String word) {
        return word.matches("[а-яА-ЯїЇєЄіІґҐ]+");
    }

    public static boolean isEnglishPhrase(String phrase) {
        return phrase.matches("[a-zA-Z\\s]+");
    }
}
