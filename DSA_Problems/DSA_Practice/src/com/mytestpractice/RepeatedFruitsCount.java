package com.mytestpractice;


import java.util.*;

public class RepeatedFruitsCount {
    public static void main(String[] args) {
        String fruits = "Apple,Banana,Apple,Cherry,Banana,Apple,Cherry";

        // Split the input string by comma
        String[] fruitArray = fruits.split(",");

        // Use HashMap to store frequency
        Map<String, Integer> fruitCount = new HashMap<>();

        for (String fruit : fruitArray) {
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);
        }

        // Print only repeated fruits
        System.out.println("Repeated Fruits and their counts:");
        fruitCount.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .forEach(entry -> 
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
