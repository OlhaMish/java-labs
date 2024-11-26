package com.olechok;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");
        String input = scanner.nextLine();

        String result = findWordWithFewestUniqueChars(input);
        if (!result.isEmpty()) {
            System.out.println("Word with minimum unique characters: " + result);
        } else {
            System.out.println("No valid words found.");
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
