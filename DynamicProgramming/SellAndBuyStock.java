class SellAndBuyStock{
    public int SellAndBuyStock1NOP(int[] prices){
        // non optimized version
        // we have a dp table dp[i][0] means the value we earn at day i
        // when we dont have stock
        // dp[i][1] means the value we earn at day i when we have stock.
        
        int n = prices.length;
        int[][] dp = new int[n][2];
        // initilize the value
        // we have nothing in the first day and we dont have any stock
        dp[0][0] = 0;
        // it is impossible to have stock before day1 so
        dp[0][1] = -prices[0];
        for(int i= 1;i < n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-pricess[i]);
        }
        return dp[n-1][0];
    }

    public int SellAndBuyStockOP(int[] prices){
        //since we only use two variables, we can optimized in space.
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for(int i = 1;i < n;i++){
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }

    public int SellAndBuyStock2(int[] prices){
        // In this case, you can buy and sell stock infinity times.
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for(int i = 1;i < n;i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp-prices[i]);
        }
        return dp_i_0;
    }

    public int SellAndBuyStockCoolDownNOP(int[] prices){
        // non optimized version
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0;i < n;i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if(i == 1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    public int SellAndBuyStockCoolDownOP(int[] prices){
        // we can also optimized the space with only 4 variables.
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        int prev = dp_i_0;
        int prevPrev = dp_i_0;
        for(int i = 1;i < n;i++){
            if(i == 1){
                dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
                dp_i_1 = Math.max(dp_i_1,-prices[i]);
                continue;
            }
            prevPrev = prev;
            prev = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1= Math.max(dp_i_1,prevPrev-prices[i]);
        }
        return dp_i_0;
    }
}