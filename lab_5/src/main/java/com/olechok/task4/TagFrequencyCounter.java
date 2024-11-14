package com.olechok.task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;

public class TagFrequencyCounter {

    public Map<String, Integer> countTags(String htmlContent) {
        Document doc = Jsoup.parse(htmlContent);
        Map<String, Integer> tagFrequency = new HashMap<>();

        for (Element element : doc.getAllElements()) {
            String tagName = element.tagName();
            tagFrequency.put(tagName, tagFrequency.getOrDefault(tagName, 0) + 1);
        }

        return tagFrequency;
    }

    public void printTagFrequency(Map<String, Integer> tagFrequency) {
        System.out.println("Tags in lexicographic order:");
        tagFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("\nTags by frequency of appearance:");
        tagFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        String url = "https://olhamish.github.io/frontend-basics-labs/lab1/index.html";
        try {
            String htmlContent = Jsoup.connect(url).get().html();
            TagFrequencyCounter counter = new TagFrequencyCounter();
            Map<String, Integer> tagFrequency = counter.countTags(htmlContent);
            counter.printTagFrequency(tagFrequency);
        } catch (IOException e) {
            System.out.println("Error connecting to URL: " + e.getMessage());
        }
    }
}
