public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
          
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int ans = 0;
        boolean hasMiddle = false;
        
        int[] t = new int[256];
        Arrays.fill(t, 0);
        for (int i = 0; i < s.length(); ++i) {
            t[s.charAt(i)]++;
        }
        
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 1) {
                hasMiddle = true;
            }
            ans += t[i] / 2 * 2;
        }
        
        return hasMiddle ? ans + 1 : ans;
    }
}