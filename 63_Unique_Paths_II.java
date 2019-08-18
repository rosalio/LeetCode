class Solution {
        
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] ans = new int[m][n];
        ans[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            ans[i][0] = obstacleGrid[i][0] == 1 ? 0 : ans[i - 1][0];
        }
        
        for (int j = 1; j < n; j++) {
            ans[0][j] = obstacleGrid[0][j] == 1 ? 0 : ans[0][j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    ans[i][j] = ans[i][j - 1] + ans[i - 1][j];
                }
            }
        }

        return ans[m - 1][n - 1];
    }
}