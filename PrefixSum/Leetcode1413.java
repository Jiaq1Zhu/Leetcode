public class Leetcode1413 {
    public int minStartValue(int[] nums) {
        // simple prefixSum problem
        int[] prefixSum = Arrays.copyOf(nums,nums.length);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i <nums.length;i++){
            prefixSum[i] += prefixSum[i-1];
        }
        for(int i = 0;i < nums.length;i++){
            min = Math.min(min,prefixSum[i]);
        }
        if(min >= 0)return 1;
        else{
            return (min*-1)+1;
        }
    }
}
