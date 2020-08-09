class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        
        int j = i + 1;
        while (j < nums.length && nums[j] > nums[i]) {
            j++;
        }
        j--;
        
        swap(nums, i, j);
        
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}