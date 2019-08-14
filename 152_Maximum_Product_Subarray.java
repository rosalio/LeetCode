class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
    
        int[] f = new int[len];
        int[] g = new int[len];
        
        f[0] = nums[0];
        g[0] = nums[0];
        
        for (int i = 1; i < len; i++) {
            f[i] = Math.max(nums[i], Integer.max(nums[i] * f[i - 1], nums[i] * g[i - 1]));
            g[i] = Math.min(nums[i], Integer.min(nums[i] * f[i - 1], nums[i] * g[i - 1]));   
        }
        
        int result = f[0];
        for (int i = 0 ; i < f.length; i++) {
            if (f[i] > result) {
                result = f[i];
            }
        }
        return result;
    }
}