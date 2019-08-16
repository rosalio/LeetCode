class Solution {
    
    private List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generate("", 0, 0, n);
        return result;
    }
    
    private void generate(String temp, int open, int close, int max) {
        if (temp.length() == 2 * max) {
            result.add(temp);
        }
        
        if (open < max) {
            generate(temp + '(', open + 1, close, max);
        }
        
        if (close < open) {
            generate(temp + ')', open, close + 1, max);
        }
    }
    
}