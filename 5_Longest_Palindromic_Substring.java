class Solution {
    
    private int low = 0;
    private int maxLen = 0;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            process(s, i, i);
            process(s, i, i + 1);
        }
        
        return s.substring(this.low, this.low + this.maxLen);
    }
    
    private void process(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        int currentLen = j - i - 1;
        if (currentLen > this.maxLen) {
            this.maxLen = currentLen;
            this.low = i + 1;
        }
    }
}