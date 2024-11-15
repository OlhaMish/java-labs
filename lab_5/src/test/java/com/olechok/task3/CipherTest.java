package com.olechok.task3;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipherTest {

    @Test
    public void testEncryption() throws IOException {
        String originalText = "HELLO, WORLD!";

        StringWriter stringWriter = new StringWriter();
        char key = 32;
        try (CipherFilterWriter writer = new CipherFilterWriter(stringWriter, key)) {
            for (int i = 0; i < originalText.length(); i++) {
                writer.write(originalText.charAt(i));
            }
        }
        String encryptedText = stringWriter.toString();

        assertEquals(originalText.length(), encryptedText.length());

        String expectedEncryptedText = "helloL@worldA";
        assertEquals(expectedEncryptedText, encryptedText);
    }

    @Test
    void testWriteEncryption() throws IOException {
        StringWriter stringWriter = new StringWriter();
        char key = 3;  // For example, using key '3' (shift 3 for encryption)
        CipherFilterWriter cipherWriter = new CipherFilterWriter(stringWriter, key);

        cipherWriter.write('A');  // ASCII of 'A' is 65, after encryption it will be 65 + 3 = 68 (D)
        cipherWriter.write('B');  // ASCII of 'B' is 66, after encryption it will be 66 + 3 = 69 (E)
        cipherWriter.write('C');  // ASCII of 'C' is 67, after encryption it will be 67 + 3 = 70 (F)

        cipherWriter.flush();
        cipherWriter.close();

        String encryptedText = stringWriter.toString();
        assertEquals("DEF", encryptedText);  // The output should be "DEF" after applying the key shift of 3
    }


    @Test
    void testReadDecryption() throws IOException {
        String encryptedText = "DEF";  // Already encrypted text (with key 3)
        StringReader stringReader = new StringReader(encryptedText);
        char key = 3;
        CipherFilterReader cipherReader = new CipherFilterReader(stringReader, key);

        int c1 = cipherReader.read();  // Should decrypt to 'A'
        int c2 = cipherReader.read();  // Should decrypt to 'B'
        int c3 = cipherReader.read();  // Should decrypt to 'C'

        assertEquals('A', c1);
        assertEquals('B', c2);
        assertEquals('C', c3);

        cipherReader.close();
    }


    @Test
    void testWriteEncryptionWithKeyE() throws IOException {
        StringWriter stringWriter = new StringWriter();
        char key = 'e';  // Key 'e', ASCII value 101
        CipherFilterWriter cipherWriter = new CipherFilterWriter(stringWriter, key);

        // Encrypt the characters 'A', 'B', 'C' with the key 'e'
        cipherWriter.write('A');  // 'A' = 65 + 101 = 166 (non-printable char, depends on system)
        cipherWriter.write('B');  // 'B' = 66 + 101 = 167 (non-printable char, depends on system)
        cipherWriter.write('C');  // 'C' = 67 + 101 = 168 (non-printable char, depends on system)

        cipherWriter.flush();
        cipherWriter.close();

        // Get encrypted result as string, which may appear as non-printable characters
        String encryptedText = stringWriter.toString();
        assertEquals(new String(new char[]{(char) 166, (char) 167, (char) 168}), encryptedText);
    }
}

