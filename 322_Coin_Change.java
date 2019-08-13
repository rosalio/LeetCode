public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        result[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && result[i - coins[j]] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i - coins[j]] + 1, result[i]);
                }
            }
        }
        if (result[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return result[amount];
    }
}