public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        
        int[][] f = new int[n + 1][5 + 1];
        int i, j, k;
        for (k = 1; k <= 5; k++) {
            f[0][k] = Integer.MIN_VALUE; // impossible
        }
        
        f[0][1] = 0;
        for (i = 1; i <= n; i++) {
            // stage 1, 3, 5: f[i][j] = max(f[i-1][j], f[i-1][j-1]+ pi-1 - pi-2)
            for (j = 1; j <= 5; j += 2) {
                f[i][j] = f[i - 1][j]; // keep state

                // sell today
                if (j > 1 && i > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            
            // stage 2, 4: f[i][j] = max(f[i - 1][j] + pi-1 - pi-2, f[i-1][j-1])
            for (j = 2; j <= 5; j +=2) {
                f[i][j] = f[i - 1][j - 1]; // buy today
                
                // keep state, calculate profit today
                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        
        int res = 0;
        for (j = 1; j <= 5; j += 2) {
            res = Math.max(res, f[n][j]);
        }
        return res;
    }
}