class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) return 0;
        
        int[] table = new int[256];
        Arrays.fill(table, 0);
        int count = 0;
        int l = 0;
        int r = 0;
        
        int ans = 0;
        char[] ss = s.toCharArray();
        for (r = 0; r < ss.length; ++r) {
            if (table[ss[r]] == 0) {
                table[ss[r]]++;
                count++;
            } else {
                table[ss[r]]++;
            }
            
            if (count <= k) {
                ans = Math.max(ans, r - l + 1);
            } else {
                while (count > k) {
                    table[ss[l]]--;
                    if (table[ss[l]] == 0) {
                        count--;
                    }
                    l++;
                }
            }
        }
        
        return ans;   
    }
}