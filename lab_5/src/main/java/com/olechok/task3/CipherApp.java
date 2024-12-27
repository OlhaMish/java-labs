package com.olechok.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CipherApp {

    private static final Logger logger = LogManager.getLogger(CipherApp.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = selectLanguage(scanner);

        logger.info(messages.getString("start.app"));

        System.out.print(messages.getString("input.file.path") + ": ");
        String inputFilePath = scanner.nextLine();

        System.out.print(messages.getString("encrypted.file.path") + ": ");
        String encryptedFilePath = scanner.nextLine();

        System.out.print(messages.getString("decrypted.file.path") + ": ");
        String decryptedFilePath = scanner.nextLine();

        System.out.print(messages.getString("encryption.key") + ": ");
        char key = scanner.nextLine().charAt(0);

        try (Reader reader = new FileReader(inputFilePath);
             CipherFilterWriter writer = new CipherFilterWriter(new FileWriter(encryptedFilePath), key)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            logger.info(messages.getString("encryption.success") + encryptedFilePath);
            System.out.println(messages.getString("encryption.success") + encryptedFilePath);
        } catch (IOException e) {
            logger.error(messages.getString("encryption.error") + e.getMessage(), e);
            e.printStackTrace();
        }

        try (CipherFilterReader reader = new CipherFilterReader(new FileReader(encryptedFilePath), key);
             Writer writer = new FileWriter(decryptedFilePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            logger.info(messages.getString("decryption.success") + decryptedFilePath);
            System.out.println(messages.getString("decryption.success") + decryptedFilePath);
        } catch (IOException e) {
            logger.error(messages.getString("decryption.error") + e.getMessage(), e);
            e.printStackTrace();
        }

        logger.info(messages.getString("end.app"));
    }

    private static ResourceBundle selectLanguage(Scanner scanner) {
        System.out.println("Select language / Виберіть мову:");
        System.out.println("1. English\n2. Українська");
        int languageChoice = Integer.parseInt(scanner.nextLine());

        Locale locale;
        if (languageChoice == 2) {
            locale = new Locale("uk", "UA");
        } else {
            locale = new Locale("en", "US");
        }

        return ResourceBundle.getBundle("location/messages", locale);
    }
}
