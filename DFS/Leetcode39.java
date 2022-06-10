class Leetcode39{
    /**
     * In this problem, we need to return all combination created from candidates
     * All combination has the same sum as target
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort the array for further prune.
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }

    public void dfs(int[] nums, int start,int target){
        if(target == 0){
            // in this case the number in list is a combination that we want.
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < nums.length;i++){
            // pruned here
            // following number are all out of our consideration.
            if(nums[i] > target)break;
            list.add(nums[i]);
            // be carefull here, be mindful there is speical descrption in the question "The same number may be chosen from candidates an unlimited number of times. "
            dfs(nums,i,target-nums[i]);
            list.remove(list.size()-1);
            while(i < nums.length-1 && nums[i] == nums[i+1])i++;
        }
    }
}