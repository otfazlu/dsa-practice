package com.mytestpractice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharStream {
    public static Character firstNonRepeatedChar(String s) {
        // Step 1: Build a LinkedHashMap of character frequencies using Stream
    	 Map<Character, Long> freqMap = new LinkedHashMap<>(); 
        freqMap = s.chars() // convert to IntStream
                .mapToObj(c -> (char) c) // convert to Character stream
                .collect(Collectors.groupingBy(
                        Function.identity(), // key = character
                        LinkedHashMap::new,  // preserve insertion order
                        Collectors.counting() // count frequency
                ));

        // Step 2: Find first entry with value = 1
        System.out.println(freqMap);
        return freqMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null); // return null if no unique character found
    }

    public static void main(String[] args) {
        String s = "hello";
        Character result = firstNonRepeatedChar(s);
        System.out.println("First non-repeated character: " + (result != null ? result : "None"));
    }
}
