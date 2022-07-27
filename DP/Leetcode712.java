public class Leetcode712 {
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(s1,0,s2,0);
        
    }
    public int dp(String s1,int i, String s2, int j){
        int res = 0;
        // if we reach the end of s1, it means we need to delete all remaining character in s2
        if(i == s1.length()){
            for(;j < s2.length();j++){
                res += s2.charAt(j);
            }
            return res;
        }
        // if we reach the end of s2, it means we need to delete all remaining character in s1
        if(j == s2.length()){
            for(;i < s1.length();i++){
                res += s1.charAt(i);
            }
            return res;
        }
        if(memo[i][j] != -1)return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            // need no deletion
            memo[i][j] = dp(s1,i+1,s2,j+1);
        }else{
            // delete the one with samller ASCII
            memo[i][j] = Math.min(dp(s1,i+1,s2,j)+s1.charAt(i),dp(s1,i,s2,j+1)+s2.charAt(j));
        }
        return memo[i][j];
    }

    public int minimumDeleteSumDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // let's define dp[i][j] is ans to problem with string s1[i:] and s2[j:]
        int[][] dp = new int[m+1][n+1];
        for(int i = m-1; i>= 0;i--){
            // so when s2 is running out, we need to remove remaining character in s1
            dp[i][n] = dp[i+1][n] + s1.charAt(i);
        }
        for(int i = n-1; i >= 0;i--){
            // so when s1 is running out, we need to remove remaining character in s2
            dp[m][i] = dp[m][i+1] + s2.charAt(i);
        }
        for(int i = m-1;i >= 0;i--){
            for(int j = n-1;j >= 0;j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    // we need no deletion
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    // find the smallest deletion
                    dp[i][j] = Math.min(dp[i+1][j]+s1.charAt(i),dp[i][j+1]+s2.charAt(j));
                }
            }
        }
        return dp[0][0];
    }


}
