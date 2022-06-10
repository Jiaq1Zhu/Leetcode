public class Leetcode46 {
    /**
     * We need to find every premutation of given array in this question
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)return res;
        dfs(nums);
        return res;
    }
    
    public void dfs(int[] nums){
        if(list.size() == nums.length){
            // if all elements from original array is included.
            // we consider it as a valid premutation.
            res.add(new ArrayList<>(list));
        }
        for(int i = 0;i <nums.length;i++){
            /**
             * In this question every element is unique.
             * So we our premutation already contains a element, we can skip it.
             */
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            dfs(nums);
            list.remove(list.size()-1);
        }
    }
}
