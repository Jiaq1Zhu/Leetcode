public class Leetcode78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(),nums,0);
        return res;
    }
    
    public void dfs(List<Integer> list,int[] nums, int start){
        // no certain condition, every list can be consider as a valid subset of current array.
        res.add(new ArrayList<>(list));
        for(int i = start;i <nums.length;i++){
            list.add(nums[i]);
            dfs(list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
