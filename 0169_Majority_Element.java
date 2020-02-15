class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        
        for (int num : nums) {
            if (num == res) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                count++;
                res = num;
            }
        }
        
        return res;
    }
}