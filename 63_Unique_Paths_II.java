class Solution {
        
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ans[i][j] = 0;
                    continue;
                }
                
                if (i == 0 && j == 0) {
                    ans[i][j] = 1;
                    continue;
                }
                
                ans[i][j] = 0;
                if (i > 0) {
                    ans[i][j] += ans[i - 1][j];
                }
                
                if (j > 0) {
                    ans[i][j] += ans[i][j - 1];
                }
            }
        }

        return ans[m - 1][n - 1];
    }
}