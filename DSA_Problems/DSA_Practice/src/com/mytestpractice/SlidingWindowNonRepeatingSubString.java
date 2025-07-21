package com.mytestpractice;

import java.util.Arrays;

public class SlidingWindowNonRepeatingSubString {
    public static int lengthOfLongestSubstring(String s) {
        // For ASCII; use Map<Character, Integer> for Unicode if needed
        int[] lastPos = new int[128];      // default 0
        Arrays.fill(lastPos, -1);          // -1 means "not seen yet"

        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If we've seen c inside current window, shrink from the left
            if (lastPos[c] >= left) {
                left = lastPos[c] + 1;
            }

            lastPos[c] = right;            // store latest index
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        String[] testCases = {
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "",
            "au",
            "dvdf",
            "abba"
        };

        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\"");
            System.out.println("Longest substring without repeating characters: " + lengthOfLongestSubstring(test));
            System.out.println("------");
        }
    }
}

