package com.olechok.task4;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TagFrequencyCounterTest {

    @Test
    public void testCountTags() {
        String html = "<html><body><div><p></p></div><p></p></body></html>";
        TagFrequencyCounter counter = new TagFrequencyCounter();
        Map<String, Integer> tagFrequency = counter.countTags(html);

        // Expected tag frequencies: <html> 1, <body> 1, <div> 1, <p> 2
        assertEquals(1, tagFrequency.get("html"));
        assertEquals(1, tagFrequency.get("body"));
        assertEquals(1, tagFrequency.get("div"));
        assertEquals(2, tagFrequency.get("p"));
    }

    @Test
    public void testCountTagsWithSingleTag() {
        String html = "<html></html>";
        TagFrequencyCounter counter = new TagFrequencyCounter();
        Map<String, Integer> tagFrequency = counter.countTags(html);

        // Only <html> tag should be counted
        assertEquals(1, tagFrequency.get("html"));
    }

    @Test
    public void testCountTagsWithMultipleSameTags() {
        String html = "<div><div><div></div></div></div>";
        TagFrequencyCounter counter = new TagFrequencyCounter();
        Map<String, Integer> tagFrequency = counter.countTags(html);

        // Only <div> tag should be counted, 3 times
        assertEquals(3, tagFrequency.get("div"));
    }

    @Test
    public void testTagFrequencySorted() {
        String html = "<div><p><div></div></p></div>";
        TagFrequencyCounter counter = new TagFrequencyCounter();
        Map<String, Integer> tagFrequency = counter.countTags(html);

        // Check lexicographic order of the tags
        assertTrue(tagFrequency.containsKey("div"));
        assertTrue(tagFrequency.containsKey("p"));
    }
}
