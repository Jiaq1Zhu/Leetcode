class HouseRobberAll{
    public static int houseRobber1NOP(int[] nums){
        //non optimized version
        // dp[i] means the highest gain when you comes to house i;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < n;i++){
            dp[i] = Math.max(nums[i]+ dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }

    public static int houseRobber1OP(int[] nums){
        //space optimized version
        // since we only needs two variables. 
        /*
        The value when we rob previous house
        The value when we rob the house before previou house
         */
        int n = nums.length;
        int prevPrev = 0;
        int prev = nums[0];
        int curr = prev;
        for(int i = 1;i < n;i++){
            curr = Math.max(prevPrev + nums[i],prev);
            prevPrev = prev;
            prev = curr;
        }
        return curr;   
    }

    public static int houseRobber2(int[] nums){
        // In this case we have all houses in  circle so we canno rob the head and tail at the same time
        // So we will need to create helper function called RobRange() to handle both situtaions.
        int n = nums.length;
        return Math.max(robRange(nums,0,n-2),robRnage(1,n-1));
    }

    private static int robRange(int[]nums,int start, int end){
        // we only rob the house in range from start to end(inclusive)
        int prevPrev = 0;
        int prev = nums[start];
        int curr = prev;
        for(int i = start;i <= end;i++){
            curr = Math.max(prevPrev + nums[i],prev);
            prevPrev = prev;
            prev = curr;
        }
        return curr;
    }

    public static int houseRobber3(TreeNode root){
        // this one is a little bit triky, you cannot rob houses in connected node
        // So we came up with an elegent solution.
        // a helper function that returns res[2] array. 
        // res[0] means we rob the node
        // res[1] means we did not;
        int[] res = rob(root);
        return Math.max(res[0],res[1]);
    }

    private static int[] rob(TreeNode node){
        if(node == null)return new int[]{0,0};
        int[] left = rob(node.left);
        int[] right = rob(node.right);
        
        int robThisOne = node.val + Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        int notRobThisOne = left[0]+right[0];
        return new int[]{robThisOne,notRobThisOne};
    }
}