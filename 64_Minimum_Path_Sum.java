public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        
        int[][] ans = new int[m][n];
        int[][] pi = new int[m][n]; // 0: from top; 1: from left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    ans[0][0] = grid[0][0];
                    continue;
                }
                
                ans[i][j] = Integer.MAX_VALUE;
  
                if (i > 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j]) + grid[i][j];
                    if (ans[i][j] == ans[i - 1][j] + grid[i][j]) {
                        pi[i][j] = 0;
                    }
                }
                
                if (j > 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + grid[i][j]);
                    if (ans[i][j] == ans[i][j - 1] + grid[i][j]) {
                        pi[i][j] = 1;
                    }
                }
            }
        }
        
        int[][] paths = new int[m + n - 1][2];
        int p;
        int i = m - 1;
        int j = n - 1;
        for (p = m + n - 2; p >= 0; p--) {
            paths[p][0] = i;
            paths[p][1] = j;
            if (p == 0) {
                break;
            }
            
            if (pi[i][j] == 0) {
                i--;
            } else {
                j--;
            }
        }
        
        for (p = 0; p < m + n - 1; p++) {
            System.out.println(String.format("(%d, %d): %d", paths[p][0], paths[p][1], ans[paths[p][0]][paths[p][1]]));
        }
        
        return ans[m - 1][n - 1];
    }
}