public class Leetcode724 {
    // very simple prefixSum problem
    public int pivotIndex(int[] nums) {
        int[] prefixSum = Arrays.copyOf(nums,nums.length);
        for(int i = 1;i < nums.length;i++){
            prefixSum[i] += prefixSum[i-1];
        }
        for(int i = 0;i <nums.length;i++){
            int left = prefixSum[i]-nums[i];
            int right = prefixSum[prefixSum.length-1]-prefixSum[i];
            if(left == right)return i;
        }
        return -1;
    }
}
