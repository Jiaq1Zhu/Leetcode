public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        // dp[i] is the longest increasing subsequence while at i.
        int[] dp = new int[nums.length];
        // init to 1 since every num at least have 1
        Arrays.fill(dp,1);
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                // for num i, scan every number before it.
                // check and update it.
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        // find maximum
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
