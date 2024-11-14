package com.olechok.task3;

import java.io.*;
import java.util.Scanner;

public class CipherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("The path to the input file: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("The path to the file to save the encrypted data: ");
        String encryptedFilePath = scanner.nextLine();

        System.out.print("Path to the file to save the decrypted data: ");
        String decryptedFilePath = scanner.nextLine();

        System.out.print("The key symbol for encryption: ");
        char key = scanner.nextLine().charAt(0);

        try (Reader reader = new FileReader(inputFilePath);
             CipherFilterWriter writer = new CipherFilterWriter(new FileWriter(encryptedFilePath), key)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("The text is encrypted and written to " + encryptedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CipherFilterReader reader = new CipherFilterReader(new FileReader(encryptedFilePath), key);
             Writer writer = new FileWriter(decryptedFilePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("The text is deciphered and written to " + decryptedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
