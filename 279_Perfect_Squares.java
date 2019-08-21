public class Solution {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        int i, j;
        f[0] = 0;
        for (i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            // last perfect square is j * j
            for (j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}