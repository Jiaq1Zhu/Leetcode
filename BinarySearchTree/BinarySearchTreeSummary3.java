public class BinarySearchTreeSummary3 {
    /**
     *  The leetcode question in this summary is gonna be a little bit tricky.
     *  
     * */
    
     // Leetcode 96
     // This problem can be solved in both DP and recursive method.
     public int numTrees(int n){
        // we need a helper function to calculate how many trees we can get from number(low, high)
        memo  = new int[n+1][n+1];
        int res1 =  countTLE(1,n);
        int res2 = count(1,n);
        return res2;
     }

     // Let's first implement a TLE version
     public int countTLE(int low, int high){
         // end case, empty tree is one tree
         // this helper cause TLE because we calcualte too many overlaped case.
         if(low > high)return 1;
         int res = 0;
         for(int i = low;i <= high;i++){
             // if we use i as root
             // lets 
             int left = count(low,i-1);
             int right = count(i+1,high);
             res += left*right;
         }
         return res;
     }
     
     // let create a memo for that
     int[][] memo;

     public int count(int low, int high){
        if(low > high)return 1;
        // memo[i][j] means the number of possibile trees we can construct in range i,j
        if(memo[low][high] != 0)return memo[low][high];
        for(int i = low;i <= high;i++){
            int left = count(low,i-1);
            int right = count(i+1,high);
            memo[low][high] += left*right;
        }
        return memo[low][high];
     }


     // We can also use dp to deal with this question, but I will say that it is very hard to come up with
     // This dp is actually a math metdho that requires to have knowledge about Catalan Number

     public int numTreesDP(int n){
         //dp[i] means the number of possible trees we can construct given number i;
         int[] dp = new int[n+1];
         dp[0] = dp[1] = 1;
         for(int i = 2;i <= n;i++){
             for(int j = 0;j < i;j++){
                 // dp[j] = left subTree;
                 // dp[i-j-1] = right subTrees;
                 dp[i] += dp[j] * dp[i-j-1];
             }
         }
         return dp[n];
     }
}
