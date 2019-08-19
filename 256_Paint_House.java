public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        
        int[][] ans = new int[n + 1][3];
        for (int i = 0; i < 3; i++) {
            ans[0][i] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][k] + costs[i - 1][j]);
                }
            }
        }

        return Math.min(ans[n][0], Math.min(ans[n][1], ans[n][2]));
    }
}