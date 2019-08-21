public class Solution {
    /**
     * @param K: An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        
        int i, j, k;
        if (K > n / 2) {
            int ans = 0;
            for (i = 0; i < n - 1; i++) {
                if (prices[i + 1] - prices[i] > 0) {
                    ans += prices[i + 1] - prices[i];
                }
            }
            return ans;
        }
        
        int[][] f = new int[2][2 * K + 1 + 1];
        int old, now = 0;
        for (k = 1; k <= 2 * K + 1; k++) {
            f[0][k] = Integer.MIN_VALUE; // impossible
        }
        
        f[now][1] = 0;
        for (i = 1; i <= n; i++) {
            old = now;
            now = 1 - now;
            
            // stage 1, 3, ..., 2 * K + 1: f[i][j] = max(f[i-1][j], f[i-1][j-1]+ pi-1 - pi-2)
            for (j = 1; j <= 2 * K + 1; j += 2) {
                f[now][j] = f[old][j]; // keep state

                // sell today
                if (j > 1 && i > 1 && f[old][j - 1] != Integer.MIN_VALUE) {
                    f[now][j] = Math.max(f[now][j], f[old][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            
            // stage 2, ..., 2K: f[i][j] = max(f[i - 1][j] + pi-1 - pi-2, f[i-1][j-1])
            for (j = 2; j <= 2 * K; j +=2) {
                f[now][j] = f[old][j - 1]; // buy today
                
                // keep state, calculate profit today
                if (i > 1 && f[old][j] != Integer.MIN_VALUE) {
                    f[now][j] = Math.max(f[now][j], f[old][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        
        int res = 0;
        for (j = 1; j <= 2 * K + 1; j += 2) {
            res = Math.max(res, f[now][j]);
        }
        return res;
    }
}