import java.util.Arrays;

public class AnalyzeProfit {
    public int getMaxProfit(int[] pnl, int k){
        // for this problem we can use prefixSum;
        // let's first create a one
        int[] prefixSum = new int[pnl.length+1];
        for(int i = 0;i < prefixSum.length;i++){
            prefixSum[i+1] = prefixSum[i] + pnl[i];
        }
        // let's have a res number to store the max profit
        int res = 0;
        // then we iterator through this prefixSum array and search subarray sum within given length;
        for(int length = 1;length <= k;k++){
            for(int i = 0;i+ length < prefixSum.length;i++){
                res = Math.max(res,prefixSum[i+length]-prefixSum[i]);
            }
        }
        return res;
    }
}
