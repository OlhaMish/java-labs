package com.olechok.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MaxWordsLineFinderTest {

    private File tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = File.createTempFile("testFile", ".txt");
    }

    @AfterEach
    public void tearDown() {
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    public void testCountWords() {
        assertEquals(0, MaxWordsLineFinder.countWords(""));
        assertEquals(1, MaxWordsLineFinder.countWords("Hello"));
        assertEquals(3, MaxWordsLineFinder.countWords("Hello world Java"));
        assertEquals(5, MaxWordsLineFinder.countWords("This   is   a    test string."));
    }

    @Test
    public void testFindMaxWordsLine() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("This is the first line.\n");     // 5 слів
            writer.write("Short line.\n");                 // 2 слова
            writer.write("This line has the most words."); // 6 слів
        }

        String expectedMaxWordsLine = "This line has the most words.";
        String actualMaxWordsLine = MaxWordsLineFinder.findMaxWordsLine(tempFile.getAbsolutePath());
        assertEquals(expectedMaxWordsLine, actualMaxWordsLine);
    }

    @Test
    public void testFindMaxWordsLine_EmptyFile() throws IOException {
        String actualMaxWordsLine = MaxWordsLineFinder.findMaxWordsLine(tempFile.getAbsolutePath());
        assertNull(actualMaxWordsLine);
    }
}
