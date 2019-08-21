class Solution {
      public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        
        int max = 0;
        for (int j = 0; j < n; j++) {
            f[j] = 1;
            // previous element A[i]
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            max = Math.max(f[j], max);
        }
        return max;
    }
}