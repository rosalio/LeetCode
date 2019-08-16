class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        if (m == 0) {
            return 0;
        }
        int n = costs[0].length;
        
        if (m == 1) {
            return findMin(costs[0]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] last = costs[i - 1];
                costs[i][j] += findMin(last, j);
            }
        }
        
        return findMin(costs[m - 1]);
    }
    
    private int findMin(int[] nums, int j) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == j) {
                continue;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
    
    private int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
    
}