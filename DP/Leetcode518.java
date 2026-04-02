public class Leetcode518 {
    /*
     * This problem can be solved using dynamic programming.
     * dp[i] represents the number of ways to make amount i.
     * We initialize dp[0] = 1 since there is one way to make amount 0 (using no
     * coins).
     * For each coin, we update the dp array to reflect the number of ways to make
     * each amount.
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
