public class Leetcode3316 {
    /*
     * 这一题的难点主要是在需要把最多需要删除变成，可以删除 -
     * 最少需要保留这样，然后再根据这个思路来做DP，DP的状态是dp[i][j]，表示在source的前i个字符和pattern的前j个字符中，
     * 最少需要保留多少个targetIndices中的字符。最后答案就是targetIndices.length - dp[m][n]。
     */
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int m = source.length(), n = pattern.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, 9999999);
        dp[0][0] = 0;
        boolean[] isTarget = new boolean[m];
        for (int i : targetIndices)
            isTarget[i] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
                if (j > 0 && source.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (isTarget[i - 1] ? 1 : 0));
                }
            }
        }
        return targetIndices.length - dp[m][n];
    }
}
