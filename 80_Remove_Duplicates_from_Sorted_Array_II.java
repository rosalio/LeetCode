class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int ans = 2;
        for (int i = ans; i < nums.length; i++) {
            if (nums[i] != nums[ans - 2]) {
                nums[ans++] = nums[i];
            }
        }
        return ans; 
    }
}