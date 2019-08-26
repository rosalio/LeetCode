class Solution {
    public void moveZeroes(int[] nums) {
        int w = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                nums[w++] = nums[r++];
            } else {
                r++;
            }
        }
        while(w < nums.length) {
            nums[w++] = 0;
        }
    }
}