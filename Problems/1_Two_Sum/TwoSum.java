/**********************************************************************************************************************

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

**********************************************************************************************************************/

import java.util.HashMap;

class TwoSum {
    public static void main(String[] args) {
        System.out.println("1. Two Sum");

        int[] input = {2, 7, 11, 15};
        int target = 9;

        int[] output = twoSum(input, target);

        for (final int n : output) {
          System.out.println(n);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        final HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            final int num = nums[i];
            if (map.containsKey(target - num)) {
                final int firstIndex = map.get(target - num);
                result[0] = firstIndex;
                result[1] = i;
                return result;
            }
            map.put(num, i);
        }
        return result;
    }
}
