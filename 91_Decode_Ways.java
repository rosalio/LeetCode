public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        char[] ss = s.toCharArray();
        if (ss.length == 1) {
            return ss[0] == '0' ? 0 : 1;    
        }
        
        int[] ans = new int[ss.length + 1];
        ans[0] = 1;
        ans[1] = ss[0] == '0' ? 0 : 1;
        
        for (int  i = 2; i <= ss.length; i++) {
            int count = 0;
            if (ss[i - 1] != '0') {
                count += ans[i - 1];
            }
            if ((ss[i - 2] == '1') || (ss[i - 2] == '2' && ss[i - 1] <= '6')) {
                count += ans[i - 2];
            }
            ans[i] = count;
        }
        return ans[ss.length];
    }
}