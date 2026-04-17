public class Leetcode5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        int begin = 0, maxLen = 1;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    begin = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
