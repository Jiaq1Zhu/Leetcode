class Leetcode974{
    /*
     * We have to have a basic math foundation overhere as the key to solve this problem
     * So we are looking for subarray that is divisible by k.
     * If we have i,j and i < j, if sum(nums[0,i])%k == sum(nums[0,j])%k. then sum(nums[i,j])%k == 0;
     * After we know that.for every j, we try to find how many i that has same value with it.
     * We can do it by using hashMap.
     */

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0,sum = 0;
        for(int i:nums){
            sum = (sum + i)%k;
            if(sum < 0){
                sum += k;
            }
            count += map.getOrDefault(sum,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}