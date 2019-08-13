class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] result = new boolean[len];
        result[0] = true;
        
        int i = 0;
        while (i < len) {
            if (result[i]) {
                int val = nums[i];
                for (int j = 1; j <= val && i + j < len; j++) {
                    result[i + j] = true;
                }
            }
            i++;
        }
        
        return result[len - 1];
    }
}