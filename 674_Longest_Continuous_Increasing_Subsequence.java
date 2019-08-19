class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        
        int[] increaseLast = new int[len + 1];
        int[] increaseLength = new int[len + 1];
           
        increaseLast[0] = Integer.MIN_VALUE;
        increaseLength[0] = 0;
        
        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] > increaseLast[i - 1]) {
                increaseLength[i] = increaseLength[i - 1] + 1;
            } else {
                increaseLength[i] = 1;
            }
            increaseLast[i] = nums[i - 1];
        }
        
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            ans = Math.max(ans, increaseLength[i]);
        } 
        return ans;
    }
}