public class Leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int left = 0, right = 0, count = 0, product = 1;
        while (right < nums.length) {
            product *= nums[right++];
            while (product >= k) {
                product /= nums[left++];
            }
            count += (right - left);

        }
        return count;
    }
}
