public class Leetcode303 {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = nums;
        for(int i = 1;i < nums.length;i++){
            preSum[i] += preSum[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0)return preSum[right];
        return preSum[right]-preSum[left-1];
    }
}
