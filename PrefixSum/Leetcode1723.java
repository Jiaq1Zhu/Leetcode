public class Leetcode1723 {
    public int largestAltitude(int[] gain) {
        int[] prefixSum = new int[gain.length+1];
        for(int i = 0;i < gain.length;i++){
            prefixSum[i+1] = prefixSum[i]+gain[i];
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0;i< prefixSum.length;i++){
            res = Math.max(prefixSum[i],res);
        }
        return res;
    }
}
