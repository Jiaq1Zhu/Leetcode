public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: There is one way to make the target 0 (using no numbers)
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num]; // Add the combinations that can be formed by using num
                }
            }
        }
        return dp[target];
    }
}
