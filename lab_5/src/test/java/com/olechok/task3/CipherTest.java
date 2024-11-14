package com.olechok.task3;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipherTest {

    private final char key = ' '; // 32

    @Test
    public void testEncryption() throws IOException {
        String originalText = "HELLO, WORLD!";

        // Використовуємо StringWriter замість FileWriter для тестування
        StringWriter stringWriter = new StringWriter();
        try (CipherFilterWriter writer = new CipherFilterWriter(stringWriter, key)) {
            writer.write(originalText);
        }

        // Отримуємо зашифрований текст
        String encryptedText = stringWriter.toString();

        // Перевіряємо, що зашифрований текст відрізняється від оригінального
        assertEquals(originalText.length(), encryptedText.length());
        assertEquals("helloL@worldA", encryptedText); // Результат залежить від ключа
    }

    @Test
    public void testDecryption() throws IOException {
        String originalText = "Hello, World!";

        // Спочатку зашифровуємо текст
        StringWriter stringWriter = new StringWriter();
        try (CipherFilterWriter writer = new CipherFilterWriter(stringWriter, key)) {
            writer.write(originalText);
        }
        String encryptedText = stringWriter.toString();

        // Використовуємо StringReader замість FileReader для тестування
        StringReader stringReader = new StringReader(encryptedText);
        StringBuilder decryptedText = new StringBuilder();

        try (CipherFilterReader reader = new CipherFilterReader(stringReader, key)) {
            int character;
            while ((character = reader.read()) != -1) {
                decryptedText.append((char) character);
            }
        }

        // Перевіряємо, що дешифрований текст дорівнює оригінальному
        assertEquals(originalText, decryptedText.toString());
    }

    @Test
    public void testEncryptionAndDecryptionConsistency() throws IOException {
        String originalText = "Hello, World!";

        // Шифруємо текст
        StringWriter stringWriter = new StringWriter();
        try (CipherFilterWriter writer = new CipherFilterWriter(stringWriter, key)) {
            writer.write(originalText);
        }
        String encryptedText = stringWriter.toString();

        // Дешифруємо текст
        StringReader stringReader = new StringReader(encryptedText);
        StringBuilder decryptedText = new StringBuilder();

        try (CipherFilterReader reader = new CipherFilterReader(stringReader, key)) {
            int character;
            while ((character = reader.read()) != -1) {
                decryptedText.append((char) character);
            }
        }

        // Перевіряємо, що після шифрування та дешифрування отримуємо оригінальний текст
        assertEquals(originalText, decryptedText.toString());
    }
}

