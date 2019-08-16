class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = generateNextLevel(result);
        }
        return result;
    }
    
    private String generateNextLevel(String str) {
        StringBuilder sb = new StringBuilder();
        int num = 1;
        char tmpChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (tmpChar == curr) {
                num++;
            } else {
                sb.append("" + num + tmpChar);
                tmpChar = curr;
                num = 1;
            }
        }         
        sb.append("" + num + tmpChar);
        
        return sb.toString();
    }
}