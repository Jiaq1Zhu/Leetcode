class KnapsackProblems{
    public static int zeroOneKnapsackNonoptimized(int[] weights,int[] values, int max,int num){
        int[][] dp = new int[num+1][max+1];
        for(int i = 1;i <= num;i++){
            for(int j = 1;j <= max;j++){
                if(weights[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[num][max];
    }

    public static int zeroOneKnapsackOptimized(int[] weights, int[] values, int max){
        int[] dp = new int[max+1];
        for(int i = 1;i < weights.length+1;i++){
            for(int j = max;j >= weights[i-1];j--){
                dp[j] = Math.max(dp[j],dp[j-weights[i-1]]+values[i-1]);
            }
        }
        return dp[max];
    }
}