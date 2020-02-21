class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0, left = 0, right = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}