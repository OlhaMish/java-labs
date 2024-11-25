package com.olechok;

import java.util.HashMap;

public class Translator {
    private final HashMap<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
    }

    public void addWord(String englishWord, String ukrainianWord) {
        dictionary.put(englishWord.toLowerCase(), ukrainianWord.toLowerCase());
    }

    public String translatePhrase(String phrase) {
        String[] words = phrase.toLowerCase().split("\\s+");
        StringBuilder translatedPhrase = new StringBuilder();

        for (String word : words) {
            String translatedWord = dictionary.getOrDefault(word, "[" + word + "]");
            translatedPhrase.append(translatedWord).append(" ");
        }

        return translatedPhrase.toString().trim();
    }


}
