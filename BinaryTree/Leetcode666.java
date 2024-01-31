public class Leetcode666 {
    int res = 0;

    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0)
            return 0;
        for (int i : nums) {
            int val = i % 10;
            int index = i / 10;
            map.put(index, val);
        }
        helper(map, nums[0] / 10, 0);
        return res;

    }

    private void helper(Map<Integer, Integer> map, int index, int sum) {
        if (!map.containsKey(index))
            return;
        int level = index / 10, pos = index % 10;
        int left = (level + 1) * 10 + (pos * 2 - 1);
        int right = left + 1;
        sum += map.get(index);
        if (!map.containsKey(left) && !map.containsKey(right)) {
            res += sum;
        }
        helper(map, left, sum);
        helper(map, right, sum);
    }
}
