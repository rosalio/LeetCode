class Solution {
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        
        int i = aa.length - 1;
        int j = bb.length - 1;
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += (aa[i--] - '0');
            }
            if (j >= 0) {
                carry += (bb[j--] - '0');
            }
            
            sb.insert(0, (char)('0' + carry % 2));
            carry /= 2;
        }
        return sb.toString();
    }
}