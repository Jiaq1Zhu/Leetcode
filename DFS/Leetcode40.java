public class Leetcode40 {
    /**
     * This is pretty similiar to 39.
     * The only difference is that every element in candidates can only be used once.
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }
    
    public void dfs(int[] nums,int start, int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <nums.length;i++){
            // prune here.
            if(nums[i] > target)break;
            list.add(nums[i]);
            // Here is what we modified.
            // We increment our starting point.
            dfs(nums,i+1,target-nums[i]);
            list.remove(list.size()-1);
            while(i < nums.length-1 && nums[i] == nums[i+1])i++;
        }
    }
}
