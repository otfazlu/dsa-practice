package com.mytestpractice;

public class ConvertToUpperCase {

    public static String toUpper(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));  // Convert to uppercase
            } else {
                result.append(ch);  // Leave digits, spaces, symbols, uppercase as is
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello World 123!";
        String output = toUpper(input);
        System.out.println("Converted: " + output);
    }
}
