class Solution {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }      
            l++;
            r--;
        }
        
        if (l < r) {
            return isPalindrome(s.substring(0, l) + s.substring(l + 1)) || isPalindrome(s.substring(0, r) + s.substring(r + 1));
        }

        return true;
    }
    
    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}