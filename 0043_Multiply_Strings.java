class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        char[] n2 = num2.toCharArray();
        
        String ans = "0";
        int tailingZero = 0;
        for (int idx2 = n2.length - 1; idx2 >= 0; idx2--, tailingZero++) {
            String curr = "0";
            for (int t = 0; t < n2[idx2] - '0'; t++) {
                curr = plus(curr, num1);
            }
            for (int j = 0; j < tailingZero; j++) {
                curr = curr + "0";
            }
            ans = plus(ans, curr);
        }
        
        return ans;
    }
    
    private String plus(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        
        int idx1 = n1.length - 1;
        int idx2 = n2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            if (idx1 >=0) {
                carry += (n1[idx1--] - '0');
            }
            if (idx2 >= 0) {
                carry += (n2[idx2--] - '0');
            }
            sb.insert(0, "" + carry % 10);
            carry /= 10;
        }
        return sb.toString();
    }
}