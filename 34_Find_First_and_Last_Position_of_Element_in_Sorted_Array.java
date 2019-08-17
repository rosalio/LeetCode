class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // If not found
        if (mid < 0 || nums[mid] != target) {
            return new int[]{-1, -1};
        }
        
        int first = mid;
        int last = mid;
        while (first >= 0 && nums[first] == nums[mid]) {
            first--;
        }
        while (last < nums.length && nums[last] == nums[mid]) {
            last++;
        }
        
        return new int[]{first + 1, last - 1};   
    }
}