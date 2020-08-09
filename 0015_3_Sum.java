class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();
        
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
        
            int first = nums[i];
            
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int second = nums[j];
                int third = nums[k];
                int sum = first + second + third;
                
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(list);
                    
                    while (j < k && nums[j + 1] == second) {
                        j++;
                    }

                    while (j < k && nums[k - 1] == third) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return result;
    }
}