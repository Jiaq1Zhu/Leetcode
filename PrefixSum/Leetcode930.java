public class Leetcode930 {
    /*
     * This one is pretty similiar to 974
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i:nums){
            sum += i;
            if(goal <= sum){
                int diff = sum-goal;
                count += map.getOrDefault(diff,0);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
