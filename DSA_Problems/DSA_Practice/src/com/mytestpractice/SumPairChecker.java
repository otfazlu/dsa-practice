package com.mytestpractice;

import java.util.*;

public class SumPairChecker {

    public static boolean hasPairWithSum(List<Integer> list, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : list) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: " + num + " + " + complement + " = " + target);
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 7, 11, 15);
        int n = 9;

        boolean result = hasPairWithSum(nums, n);
        System.out.println("Result: " + result);
    }
}

