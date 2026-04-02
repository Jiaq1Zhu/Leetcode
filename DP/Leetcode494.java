public class Leetcode494 {
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dp(nums, 0, target);
    }

    private int dp(int[] nums, int i, int remain) {
        if (i == nums.length) {
            return remain == 0 ? 1 : 0;
        }
        String key = i + "," + remain;
        if (map.containsKey(key))
            return map.get(key);
        int count = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        map.put(key, count);
        return count;
    }
}
