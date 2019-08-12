class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (numToIndexMap.containsKey((complement))) {
                return new int[]{numToIndexMap.get(complement), i};
            }
            numToIndexMap.put(num, i);
        }
        throw new IllegalArgumentException("Cannot find such two numbers.");
    }
}