class Solution {
    public int jump(int[] nums) {
        //[2,3,1,1,4]        
        //[0,1,2,2,2]
        
        int[] steps = new int[nums.length];
        Arrays.fill(steps, 0);
        for (int i = 0; i < nums.length - 1; i++) {
            // min step to i is steps[i]
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    continue;
                }
                if (steps[i + j] == 0) {
                    steps[i + j] = steps[i] + 1;
                } else {
                    steps[i + j] = Math.min(steps[i + j], steps[i] + 1);
                }
            }
        }
        
        return steps[nums.length - 1];
    }
}