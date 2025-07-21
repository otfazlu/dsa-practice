package com.mytestpractice;

import java.util.Arrays;

public class DutchFlagProblem {

    /**
     * Sorts an array containing 0s, 1s, and 2s in-place using the Dutch National Flag algorithm.
     *
     * @param nums The input array of integers (expected to contain only 0, 1, or 2).
     */
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return; // No need to sort if array is null or has less than 2 elements
        }

        int low = 0;  // Pointer for the boundary between 0s and 1s
        int mid = 0;  // Pointer for the current element being examined
        int high = nums.length - 1; // Pointer for the boundary between 1s and 2s

        // Iterate while the middle pointer is within the unsorted region
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // If the current element is 0, swap it with the element at 'low'
                    // This moves the 0 to its correct position at the beginning.
                    swap(nums, low, mid);
                    low++; // Move 'low' pointer forward
                    mid++; // Move 'mid' pointer forward (as the swapped element at mid is now sorted)
                    break;
                case 1:
                    // If the current element is 1, it's already in its correct relative position
                    // within the 1s section (between 0s and 2s).
                    mid++; // Just move 'mid' pointer forward
                    break;
                case 2:
                    // If the current element is 2, swap it with the element at 'high'
                    // This moves the 2 to its correct position at the end.
                    swap(nums, mid, high);
                    high--; // Move 'high' pointer backward
                    // DO NOT increment 'mid' here, because the element swapped from 'high'
                    // into 'mid's position needs to be re-evaluated (it could be 0, 1, or 2).
                    break;
            }
        }
    }

    /**
     * Helper method to swap two elements in an array.
     * @param arr The array.
     * @param i Index of the first element.
     * @param j Index of the second element.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] colors1 = {2, 0, 2, 1, 1, 0};
        System.out.println("Original array 1: " + Arrays.toString(colors1));
        sortColors(colors1);
        System.out.println("Sorted array 1:   " + Arrays.toString(colors1)); // Expected: [0, 0, 1, 1, 2, 2]

        System.out.println("\n---------------------\n");

        int[] colors2 = {2, 0, 1};
        System.out.println("Original array 2: " + Arrays.toString(colors2));
        sortColors(colors2);
        System.out.println("Sorted array 2:   " + Arrays.toString(colors2)); // Expected: [0, 1, 2]

        System.out.println("\n---------------------\n");

        int[] colors3 = {0, 0, 0};
        System.out.println("Original array 3: " + Arrays.toString(colors3));
        sortColors(colors3);
        System.out.println("Sorted array 3:   " + Arrays.toString(colors3)); // Expected: [0, 0, 0]

        System.out.println("\n---------------------\n");

        int[] colors4 = {1, 1, 1};
        System.out.println("Original array 4: " + Arrays.toString(colors4));
        sortColors(colors4);
        System.out.println("Sorted array 4:   " + Arrays.toString(colors4)); // Expected: [1, 1, 1]

        System.out.println("\n---------------------\n");

        int[] colors5 = {2, 2, 2};
        System.out.println("Original array 5: " + Arrays.toString(colors5));
        sortColors(colors5);
        System.out.println("Sorted array 5:   " + Arrays.toString(colors5)); // Expected: [2, 2, 2]

        System.out.println("\n---------------------\n");

        int[] colors6 = {1, 0, 2};
        System.out.println("Original array 6: " + Arrays.toString(colors6));
        sortColors(colors6);
        System.out.println("Sorted array 6:   " + Arrays.toString(colors6)); // Expected: [0, 1, 2]
    }
}