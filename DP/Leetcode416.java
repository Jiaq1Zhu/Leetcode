public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int max = sum / 2;
        int[] dp = new int[max + 1];
        dp[0] = 0;
        for (int n : nums) {
            for (int i = max; i >= n; i--) {
                dp[i] = Math.max(dp[i], dp[i - n] + n);
            }
        }
        return sum - dp[max] - dp[max] == 0;
    }
}
