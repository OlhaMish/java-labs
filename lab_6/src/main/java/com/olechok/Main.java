package com.olechok;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator translator = new Translator();

        System.out.println("Наповнення словника:");
        while (true) {
            System.out.print("Введіть англійське слово (або 'stop' для завершення): ");
            String englishWord = scanner.nextLine();
            if ("stop".equalsIgnoreCase(englishWord)) {
                break;
            }
            if (!LanguageDetector.isEnglish(englishWord)) {
                System.out.println("Помилка: введіть слово англійською мовою!");
                continue;
            }

            System.out.print("Введіть переклад українською: ");
            String ukrainianWord = scanner.nextLine();
            if (!LanguageDetector.isUkrainian(ukrainianWord)) {
                System.out.println("Помилка: введіть переклад українською мовою!");
                continue;
            }

            translator.addWord(englishWord, ukrainianWord);
            System.out.println("Слово додано до словника.\n");
        }

        System.out.println("\nПереклад фрази:");
        System.out.print("Введіть фразу англійською мовою: ");
        String englishPhrase = scanner.nextLine();
        if (!LanguageDetector.isEnglishPhrase(englishPhrase)) {
            System.out.println("Помилка: фраза повинна містити лише англійські слова!");
            return;
        }

        String translatedPhrase = translator.translatePhrase(englishPhrase);
        System.out.println("Переклад українською: " + translatedPhrase);
    }

}

