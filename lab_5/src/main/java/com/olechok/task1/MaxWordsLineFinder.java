package com.olechok.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MaxWordsLineFinder {

    public static void main(String[] args) {
        String filename = getFilenameFromConsole();
        String maxWordsLine = findMaxWordsLine(filename);

        if (maxWordsLine != null) {
            int maxWordsCount = countWords(maxWordsLine);
            System.out.println("Line with the most words: " + maxWordsLine);
            System.out.println("Number of words in this line: " + maxWordsCount);
        } else {
            System.out.println("File is empty or no line found.");
        }
    }

    private static String getFilenameFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        return scanner.nextLine();
    }

    static String findMaxWordsLine(String filename) {
        String maxWordsLine = null;
        int maxWordsCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int wordsCount = countWords(line);
                if (wordsCount > maxWordsCount) {
                    maxWordsCount = wordsCount;
                    maxWordsLine = line;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return maxWordsLine;
    }

    static int countWords(String line) {
        if (line.isEmpty()) {
            return 0;
        } else {
            return line.split("\\s+").length;
        }
    }

}
