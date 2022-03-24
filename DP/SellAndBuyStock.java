class SellAndBuyStock{
    public static int SellAndBuyStock1NOP(int[] prices){
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
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];
    }

    public static int SellAndBuyStockOP(int[] prices){
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

    public static int SellAndBuyStock2(int[] prices){
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

    public static int SellAndBuyStockCoolDownNOP(int[] prices){
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

    public static int SellAndBuyStockCoolDownOP(int[] prices){
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
    public static int SellAndBuyStockWithFee(int[] prices, int fee){
        // this case we just add fees to each transaction.
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0;i < n;i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    public static int SellAndBuyStockIINOP(int[] prices){
        //Non optimized version
        //in this case we can only make 2 transactions.
        // so there with 3dimensional array dp[i][k][2]
        // K means the transaction we have can make
        int maxK = 2;
        int n = prices.length;
        int[][][] dp = new int[n][maxK+1][2];
        for(int i = 0;i < n;i++){
            //we iterator backword, forward will also work as well.
            for(int k = maxK;k >= 1;k--){
                if(i == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][maxK][0];
    }

    public static int SellAndBuyStockIIOP(int []prices){
        // since we k max is equal to 2 we can optimize its space.
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for(int price:prices){
            dp_i20 = Math.max(dp_i20,dp_i21+price);
            dp_i21 = Math.max(dp_i21,dp_i10-price);
            dp_i10 = Math.max(dp_i10,dp_i11+price);
            dp_i11 = Math.max(dp_i11,-price);
        }
        return dp_i20;
    }

    public static int SellAndBuyStockIV(int k, int[] prices){
        int n = prices.length;
        if(n == 0)return 0;
        // if k > n/2 is equal to infinity so just use sellandBuystockII to incase k is too large.
        /*if(k > n/2){
            return SellAndBuyStockIINOP(prices);
        }*/
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0;i< n;i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = -prices[i];
        }
        for(int i = 0;i< n;i++){
            for(int j = k;j >= 1;j--){
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }
}