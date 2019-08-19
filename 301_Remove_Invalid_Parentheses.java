class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // 1. Check whether if an input string is valid
               
        // 2. Compute min number of '(' and ')' to remove unbalanced '(' + unbalanced ')'
        
        // 3. Try all possible ways to remove r ')'s and l '('s.
        // Remove ')' first to make prefix valid
        // Only remove first parentheses if there are consecutive ones
        
        int l = 0;
        int r = 0;
        char[] ss = s.toCharArray();
        for (char ch : ss) {
            if (ch == '(') {
                l++;
            }
            if (l == 0) {
                if (ch == ')') {
                    r++;
                }
            } else {
                if (ch == ')') {
                    l--;
                }
            }
        }
        
        List<String> ans = new ArrayList<>();
        dfs(s, 0, l, r, ans);
        return  ans;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        char[] ss = s.toCharArray();
        for (char ch : ss) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
            
        }
        return count == 0;
    } 
    
    private void dfs(String s, int start, int l, int r, List<String> ans) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String copy = new String(s);
                copy = copy.substring(0, i) + copy.substring(i + 1);
                if (r > 0) {
                    dfs(copy, i, l, r - 1, ans);
                } else if (l > 0) {
                    dfs(copy, i, l - 1, r, ans);
                }
            }
        }
    }
    
}