public class Leetcode90 {
    /**
     * In this problem we need to find all subsets from a array with duplicate elements
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // like every other problem with duplicate elements, we use sort to place them together
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums,int start){
        // every list should be consider as a valid subset.
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            dfs(nums,i+1);
            list.remove(list.size()-1);
            // this will help use skip duplicate element
            while(i < nums.length - 1 && nums[i] == nums[i+1])i++;
        }
    }
}
