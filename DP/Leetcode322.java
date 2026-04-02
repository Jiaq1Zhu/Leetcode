public class Leetcode322 {
    /*
     * This problem can be solved using dynamic programming.
     * dp[i] represents the minimum number of coins needed to make amount i.
     * We initialize dp[0] = 0 since no coins are needed to make amount 0.
     * For each coin, we update the dp array to reflect the minimum coins needed.
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                // If we can make amount j by using the current coin, we update dp[j] to be the
                // minimum of its current value and dp[j - coin] + 1.
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
