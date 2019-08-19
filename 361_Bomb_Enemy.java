class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        // up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        ++up[i][j];
                    }
                    if (i > 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }
            }
        }
        
        // down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                down[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        ++down[i][j];
                    }
                    if (i < m - 1) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }
        
        // left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                left[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        ++left[i][j];
                    }
                    if (j > 0) {
                        left[i][j] += left[i][j - 1];
                    }
                }
            }
        }
        
        // right
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                right[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        ++right[i][j];
                    }
                    if (j < n - 1) {
                        right[i][j] += right[i][j + 1];
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}