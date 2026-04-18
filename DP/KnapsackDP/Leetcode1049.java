public class Leetcode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones)
            sum += s;
        int w = sum / 2;
        int[] dp = new int[w + 1];
        dp[0] = 0;
        for (int stone : stones) {
            for (int i = w; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - dp[w] - dp[w];
    }
}
