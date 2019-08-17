class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, result);
        return result;
    }
    
    
     private void dfs(int[] nums, int level, List<List<Integer>> result) {
        if (level == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : nums) {
                curr.add(num);
            }
            result.add(curr);
            return;
        }
            
        for (int i = level; i < nums.length; i++) {
            // Skip if we have duplicates of current element before i
            boolean skip = false;
            for (int j = level; j < i; j++) {
                if (nums[j] == nums[i]) {
                    skip = true;
                    break;
                }
            }
            
            if (skip) {
                continue;
            }
            
            swap(nums, level, i);
            dfs(nums, level + 1, result);
            swap(nums, level, i);
        }
    }

    private void swap(int[] num, int i, int j) {
        if (i != j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }
}
