package com.mytestpractice;

import java.util.Arrays;
import java.util.List;

class JumpGameGreedymethod {
    public static boolean canJump(int[] num) {
     int goal = num.length -1;
     for (int i = num.length-2; i>= 0; i--){
        if(goal<= num[i]+i) {
            goal = i;
        }
     }
     return goal==0;
        
    }
    public static void main(String[] args) {
        List<List<Integer>> testCases = Arrays.asList(
        		Arrays.asList(2,3,1,1,4),
        		Arrays.asList(3,2,1,0,4));

        for (List<Integer> test : testCases) {
        	int[] nums = test.stream().mapToInt(i -> i).toArray();
            System.out.println("Input: \"" + test + "\"");
            System.out.println("can we jump and reach gaol: " + canJump(nums));
            System.out.println("------");
        }
    }
}