/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Input: numbers={2, 7, 11, 15}, target=9");
        int[] output = Solution.twoSum(input, target);
        System.out.println("Output: index1=" + output[0] + ", index2=" + output[1]);
    }

    public static class Solution {

        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
            int[] result = {-1, -1};

            for (int i = 0; i < nums.length; i++) {
                if (!table.containsKey(new Integer(target - nums[i]))) {
                    table.put(new Integer(nums[i]), new Integer(i));
                } else {
                    result[0] = table.get(target - nums[i]).intValue() + 1;
                    result[1] = i + 1;
                }
            }
            return result;
        }

    }
}