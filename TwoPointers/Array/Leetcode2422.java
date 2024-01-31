public class Leetcode2422 {
    public int minimumOperations(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = 0;
        int leftSum = nums[left], rightSum = nums[right];
        while (left < right) {
            if (leftSum == rightSum) {
                left++;
                right--;
                leftSum = nums[left];
                rightSum = nums[right];
            } else if (leftSum < rightSum) {
                leftSum += nums[++left];
                res++;
            } else if (leftSum > rightSum) {
                rightSum += nums[--right];
                res++;
            }
        }
        return res;
    }
}
