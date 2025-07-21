package com.mytestpractice;

public class KadanesAlgorithm {

    /**
     * Finds the maximum sum of a contiguous subarray within a given array of integers.
     * Implements Kadane's Algorithm.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of a contiguous subarray.
     */
    public static int maxSubArraySum(int[] nums) {
        // Handle edge case: if the array is null or empty, throw an IllegalArgumentException.
        // Or, depending on problem constraints, you might return 0 or Integer.MIN_VALUE.
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }

        // max_so_far stores the maximum sum found globally across all subarrays.
        // It's initialized with the first element, as a single element can be the maximum subarray.
        int max_so_far = nums[0];

        // current_max stores the maximum sum of a subarray ending at the current position.
        // It's also initialized with the first element.
        int current_max = nums[0];

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // At each element, decide whether to extend the current subarray
            // by adding nums[i] to current_max, or to start a new subarray
            // from nums[i] itself.
            // If current_max becomes negative, it's better to start a new subarray
            // from nums[i] because adding a negative sum will only decrease the total.
            current_max = Math.max(nums[i], current_max + nums[i]);

            // Update max_so_far if the current_max is greater.
            // This ensures max_so_far always holds the overall maximum sum found.
            max_so_far = Math.max(max_so_far, current_max);
        }

        // Return the overall maximum sum found.
        return max_so_far;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Expected: 6 ([4, -1, 2, 1])
        System.out.println("Maximum subarray sum for arr1: " + maxSubArraySum(arr1));

        int[] arr2 = {1}; // Expected: 1
        System.out.println("Maximum subarray sum for arr2: " + maxSubArraySum(arr2));

        int[] arr3 = {5, 4, -1, 7, 8}; // Expected: 23 ([5, 4, -1, 7, 8])
        System.out.println("Maximum subarray sum for arr3: " + maxSubArraySum(arr3));

        int[] arr4 = {-1, -2, -3, -4}; // Expected: -1 (the largest single element)
        System.out.println("Maximum subarray sum for arr4: " + maxSubArraySum(arr4));

        int[] arr5 = {1, 2, 3, -2, 5}; // Expected: 9 ([1, 2, 3, -2, 5])
        System.out.println("Maximum subarray sum for arr5: " + maxSubArraySum(arr5));

        // Test with an empty array (should throw an exception based on current implementation)
        try {
            int[] emptyArr = {};
            System.out.println("Maximum subarray sum for emptyArr: " + maxSubArraySum(emptyArr));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for empty array: " + e.getMessage());
        }

        // Test with a null array (should throw an exception)
        try {
            int[] nullArr = null;
            System.out.println("Maximum subarray sum for nullArr: " + maxSubArraySum(nullArr));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for null array: " + e.getMessage());
        }
    }
}

