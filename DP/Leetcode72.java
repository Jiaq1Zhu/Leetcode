class Leetcode72{
    //basic dp
    //
    int minDistanceBasic(String s1,String s2){
        int m = s1.length(), n = s2.length();
        return dp(s1,m-1,s2,n-1);
    }

    int dpBasic(String s1, int i, String s2, int j){
        // scan from back to front
        //if s1 is runing out of character, we just return the remainning length of s2.
        if(i == -1)return j + 1;
        //if s2 is runing out of character, we just return the remainning length of s1.
        if(j == -1)return i + 1;
        // if character match, it means we don't need to do anything.
        // So just keep scanning
        if(s1.charAt(i) == s2.charAt(j))return dp(s1,i-1,s2,j-1);

        int delete = dp(s1,i-1,s2,j)+1;
        int insert = dp(s1,i,s2,j-1)+1;
        int replace = dp(s1,i-1,s2,j-1);
        return min(delete,replace,insert);
    }

    int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    int[][] memo;

    int minDistanceWithMemo(String s1, String s2){
        // in this method, we found duplication sub problems. We eventually go to i-1, and j-1, from three different method, if i-1,j-1 is already calculated 
        int m = s1.length(),n = s2.length();
        memo = new int[m][n];
        for(int[] row:memo){
            // init to -1 value;
            Arrays.fill(row,-1);
        }
        return dp(s1,m-1,s2,n-1);
    }

    int dpWithMemo(String s1, int i, String s2, int j){
        // so first we initilize the base case
        if(i == -1)return j+1;
        if(j == -1)return i+1;
        // found a calculated subproblem
        if(memo[i][j] != -1)return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1,i-1,s2,j-1);
        }else{
            memo[i][j] = min(dp(s1,i-1,s2,j)+1,dp(s1,i-1,s2,j-1)+1,dp(s1,i,s2,j-1)+1);
        }
        return memo[i][j];
    }

    int minDistanceDp(String s1, String s2){
        // previous memo version is top-down, now lets try bottom-up
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            dp[i][0] = i;
        }
        for(int j = 1;j <= n;j++){
            dp[0][j] = j;
        }
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = min(dp[i-1][j]+1,dp[i-1][j-1]+1,dp[i][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}