package com.olechok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

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

    public static int countUniqueCharacters(String word) {
        return (int) word.chars().distinct().count();
    }

    public static String findWordWithFewestUniqueChars(String inputString) {
        return splitIntoWords(inputString)
                .min((w1, w2) -> Integer.compare(countUniqueCharacters(w1), countUniqueCharacters(w2)))
                .orElse("");
    }

    private static Stream<String> splitIntoWords(String inputString) {
        return Stream.of(inputString.split("\\s+"));
    }
}
