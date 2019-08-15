class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int minimum = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        
        for (int right = 0; right < len; right++) {
            sum += nums[right];
            while (sum >= s) {
                minimum = Math.min(minimum, right - left + 1);
                sum -= nums[left++];
            }
        }
        
        return minimum == Integer.MAX_VALUE ? 0 : minimum;
    }
}