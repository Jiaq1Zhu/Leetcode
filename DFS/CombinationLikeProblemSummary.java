public class CombinationLikeProblemSummary {
    /**
     * In this file I will focused on how to use dfs(back tracking) to solve problems like combination, subset, permutations.
     */

     // leetcode 77
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }
    public void dfs(int n, int k, int start){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n;i++){
            list.add(i);
            dfs(n,k,i+1);
            list.remove(list.size()-1);
        }
    }

    // leetcode 78

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return res;
    }
    public void backTrack(int[] nums, int start){
        res.add(new ArrayList<>(track));
        for(int i = start;i <nums.length;i++){
            track.add(nums[i]);
            backTrack(nums,i+1);
            track.remove(track.size()-1);
        }
    }

    // leetcode 46
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }
    public void dfs(int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            dfs(res,list,nums);
            list.remove(list.size()-1);
        }
    }

    // Leetcode 90  
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sort the list so that same value will be placed together
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums, int start){
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            dfs(nums,i+1);
            list.remove(list.size()-1);
            // prune the tree here
            while(i < nums.length-1 && nums[i] == nums[i+1])i++;
        }
    }

    // Leetcode 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort the list so that same value will be placed together
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }
    private void dfs(int[] nums,int start,int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < nums.length;i++){
            // prune the tree here.
            if(target < nums[i])break;
            list.add(nums[i]);
            dfs(nums,i+1,target-nums[i]);
            list.remove(list.size()-1);
            // prune the tree here.
            while(i < nums.length-1 && nums[i] == nums[i+1])i++;
        }
    }


    // Leetcode 47
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        // sort the list so that same value will be placed together
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }
    
    private void dfs2(int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i <nums.length;i++){
            if(used[i])continue;
            list.add(nums[i]);
            // prune here
            used[i] = true;
            dfs2(nums);
            list.remove(list.size()-1);
            used[i] = false;
            // prune here
            while(i < nums.length-1 && nums[i] == nums[i+1] && !used[i+1])i++;
        }
    }

    // Leetcode 39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort the list so that same value will be placed together
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }
    private void dfs3(int[] nums,int start,int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < nums.length;i++){
            // prune the tree here.
            if(target < nums[i])break;
            list.add(nums[i]);
            // we  dont move forward by one here, so every element can be used repeatly.
            dfs3(nums,i,target-nums[i]);
            list.remove(list.size()-1);
            // prune the tree here.
            while(i < nums.length-1 && nums[i] == nums[i+1])i++;
        }
    }
}
