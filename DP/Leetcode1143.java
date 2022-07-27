public class LongestCommonSubsequence {
    public int lcs(String str1, String str2){
        // in this case, we dp[i][j] means the longest common subsequence at length i with str1 and j with str2
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                if(i ==0 || j == 0){
                    dp[i][j] = 0;
                }else if(str1.charAt(i)== str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    
}
