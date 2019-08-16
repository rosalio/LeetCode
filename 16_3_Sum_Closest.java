class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int globalSum = nums[0] + nums[1] + nums[2];
        int globalMin = Math.abs(globalSum - target);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int first = nums[i];
                int second = nums[j];
                int third = nums[k];
                
                int sum = first + second + third;
                int diff = Math.abs(sum - target);
                if (diff == 0) {
                    return target;
                } 
                if (diff < globalMin) {
                    globalMin = diff;
                    globalSum = sum;
                }
                
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }  
        }
        
        return globalSum;
    }
}