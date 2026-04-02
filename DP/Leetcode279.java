public class Leetcode279 {
    public int numSquares(int n) {
        // we can use dp to solve this problem, but we need to find the perfect square
        // number by
        // dp[i] means the least number of perfect square numbers which sum to i
        // dp[0] means the least number of perfect square numbers which sum to 0, so
        // dp[0] = 0
        // for each number i, we can find the least number of perfect square numbers
        // which sum to i by
        // dp[i] = min(dp[i], dp[i - j * j] +1) where j * j is the perfect square number
        // which is less than or equal to i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
