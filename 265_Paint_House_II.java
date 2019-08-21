class Solution {
    public int minCostII(int[][] costs) {
       if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        
        if (k == 1) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += costs[i][0];
            }
            return res;
        }
        
        
        int[][] ans = new int[n + 1][k];
        for (int i = 0; i < k; i++) {
            ans[0][i] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            // find minimum and 2nd minimum among 
            // f[i - 1][0], ..., f[i - 1][k]
            int a = -1;
            int b = -1;
            for (int l = 0; l < k; l++) {
                if(a == -1 || ans[i - 1][l] < ans[i - 1][a]) {
                    b = a;
                    a = l;
                } else {
                    if (b == -1 || ans[i - 1][l] < ans[i - 1][b]) {
                        b = l;
                    }
                }
            }
            
            for (int j = 0; j < k; j++) {
                if (j != a) {
                    ans[i][j] = ans[i - 1][a] + costs[i - 1][j];
                } else {
                    ans[i][j] = ans[i - 1][b] + costs[i - 1][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            res = Math.min(res, ans[n][j]);
        }

        return res;     
    }
}