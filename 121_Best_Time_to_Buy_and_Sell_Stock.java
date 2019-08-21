class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int res = 0;
        int minPrice = prices[0];
        for (int j = 0; j < prices.length; ++j) {
            res = Math.max(res, prices[j] - minPrice);
            minPrice = Math.min(minPrice, prices[j]);
        }
        return res;
    }
}