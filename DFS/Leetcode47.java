import java.util.ArrayList;

public class Leetcode47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        /**
         * This problem is very similar to 46, the only thing we changed is the array can now contain duplicates.
         */
        // basically the same as 46, we use sort to place duplicates together
        Arrays.sort(nums);
        // we use a boolean array to indicate which element is already in the list.
        boolean[] used = new boolean[nums.length];
        dfs(used,nums);
        return res;
    }

    public void dfs(boolean[] used, int[] nums){
        if(list.size() == nums.length){
            // this means we found a valid permutation
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            // in this case, current number is already in the list
            if(used[i])continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(used,nums);
            list.remove(list.size()-1);
            used[i] = false;
            // skip duplicate premutation
            while(i < nums.length-1 && nums[i] == nums[i+1] && !used[i])i++;
        }
    }

    
}
