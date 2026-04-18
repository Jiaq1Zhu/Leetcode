public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (Math.abs(target) > sum || (target + sum) % 2 != 0)
            return 0;

        int w = (target + sum) / 2;
        if (w < 0)
            return 0;
        int[] dp = new int[w + 1];

        dp[0] = 1;
        for (int num : nums) {
            for (int i = w; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[w];
    }
}
