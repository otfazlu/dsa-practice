package com.mytestpractice;


import java.util.*;

public class BracketValidator {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Mapping of closing to opening brackets
        Map<Character, Character> matching = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for (char ch : s.toCharArray()) {
            if (matching.containsValue(ch)) {
                // Opening bracket
                stack.push(ch);
            } else if (matching.containsKey(ch)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != matching.get(ch)) {
                    return false;
                }
            } else {
                // Ignore non-bracket characters (optional)
                continue;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        List<String> testCases = List.of(
            "()", "([])", "({[]})", "((())", "({[)]}", "abc", "[()]{}{[()()]()}", "[(])"
        );

        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Is valid? " + isValid(test));
            System.out.println("------");
        }
    }
}
