class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' '){
            i--;
        }
        return s.length() - i - 1;
    }
}