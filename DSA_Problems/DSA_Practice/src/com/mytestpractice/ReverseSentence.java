package com.mytestpractice;
import java.util.*;
import java.util.stream.*;

public class ReverseSentence {
    public static String reverseSentences(String input) {
        // Split input into sentences based on '.' and trim whitespace
        List<String> sentences = Arrays.asList(input.split("\\."));

        // Use stream to process each sentence
        List<String> reversedParts = sentences.stream()
            .map(String::trim)
            .map(s -> Arrays.asList(s.split("\\s+"))) // split into words
            .map(words -> {
                Collections.reverse(words);           // reverse the words
                return String.join(" ", words);       // join back
            })
            .collect(Collectors.toList());

        // Rejoin with period + space between sentences (if needed)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversedParts.size(); i++) {
            result.append(reversedParts.get(i));
            if (i < reversedParts.size() - 1) {
                result.append(". "); // add back period and space between segments
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "My name is Kriti. I love Programming";
        String output = reverseSentences(input);
        System.out.println("Output: \"" + output + "\"");
    }
}
