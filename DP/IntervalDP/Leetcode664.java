public Leetcode664{
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0) return 0;

        /*
        First we need to remove all duplicate, cause it makes no difference
        */
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            if(i > 0 && s.charAt(i) == s.charAt(i-1))continue;
            sb.append(s.charAt(i));
        }


        String cleaned = sb.toString();

        int n = cleaned.length();

        /* 
        dp[i][j] means the turns we need to print fron i to j
        */

        int[][] dp = new int[n][n];
        // 1 need 1 turns for sure
        for(int i = 0;i < n;i++){
            dp[i][i] = 1;
        }

        // start from len 2
        for(int len = 2; len <= n;len++){
            for(int i = 0;i <= n - len; i++){
                // for a interval we assume we need to print 1 letter at i, so 1 + dp[i+1][j]
                int j = len + i -1;
                dp[i][j] = 1 + dp[i+1][j];
                // for all breaking points in middle
                for(int k = i+1; k<= j;k++){
                    // if i and k has same char, which means when printing i, we can also cover k
                    if(cleaned.charAt(i) == cleaned.charAt(k)){
                        // check if k + 1 <= j means there are something left at behind, so we need to add them
                        // if k + 1 > j means nothing left so add zero
                        int turns = dp[i+1][k] + (k+1 <= j?dp[k+1][j]:0);
                        dp[i][j] = Math.min(dp[i][j],turns);
                    }
                }

            }
        }
        return dp[0][n-1];
    }
}