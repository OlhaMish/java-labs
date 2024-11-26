package com.olechok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter your text: \n");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            String result = findWordWithFewestUniqueChars(input);
            System.out.printf("Word with the fewest unique characters: %s%n", result);
        } catch (IOException e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }

    protected static int countUniqueCharacters(String word) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : word.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }

    protected static String findWordWithFewestUniqueChars(String inputString) {
        String[] words = inputString.split("\\s+");
        String wordWithFewestUniqueChars = "";
        int fewestUniqueCharsCount = Integer.MAX_VALUE;

        for (String word : words) {
            int uniqueCharCount = countUniqueCharacters(word);
            if (uniqueCharCount < fewestUniqueCharsCount) {
                fewestUniqueCharsCount = uniqueCharCount;
                wordWithFewestUniqueChars = word;
            }
        }
        return wordWithFewestUniqueChars;
    }
}


