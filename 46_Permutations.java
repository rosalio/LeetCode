class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result);
        return result;
    }
    
    private void dfs(int[] nums, int level, List<List<Integer>> result) {
        if (level == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                curr.add(nums[i]);
            }
            result.add(curr);
            return;
        }
        
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            dfs(nums, level + 1, result);
            swap(nums, level, i);
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