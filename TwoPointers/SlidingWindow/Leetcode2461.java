public class Leetcode2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, curSum = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            curSum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            if (right - left > k) {
                curSum -= nums[left];
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            if (right - left == k && map.size() == k) {
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }
}
