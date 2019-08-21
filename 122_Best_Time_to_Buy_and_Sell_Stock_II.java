public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int res = 0;
        for(int i = 1; i < prices.length; ++i) {
            int gain = prices[i] - prices[i - 1];
            if (gain > 0) {
                res += gain;
            }
        }
        
        return res;
    }
}