class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        
        int write = 1;
        int read = 1;
        while (read < len) {
            if (nums[read] == nums[read - 1]) {
                read++;
            } else {
                nums[write++] = nums[read++];
            }
        }
        return write;
    }
}