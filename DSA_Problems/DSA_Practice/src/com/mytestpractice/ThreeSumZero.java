package com.mytestpractice;

import java.util.*;

public class ThreeSumZero {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
//        System.out.println(nums.toString());
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for 'i'
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println("nums[i]="+nums[i]+" nums[left]="+ nums[left]+" nums[right]="+ nums[right]);
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Need a larger number
                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Triplets with zero sum: " + triplets);
    }
}


