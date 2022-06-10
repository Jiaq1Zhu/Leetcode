public class Leetcode216 {
    /*This problem add more restrictions
    * We can only use 1 to 9 and every number should only be used once
    * We need to return all combination that has length k, and sum up to n;
    */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // lets create our own candidate
        int[] nums = new int[9];
        for(int i = 0;i <nums.length;i++){
            nums[i] = i+1;
        }
        dfs(nums,n,k,0);
        return res;
        
    }
    public void dfs(int[] nums, int target, int k,int start){
        // if all requirements are met, we add this combination into res
        if(target == 0){
            if(list.size() == k){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        // try every number, no duplicate, it can only be used once.
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            dfs(nums,target-nums[i],k,i+1);
            list.remove(list.size()-1);
        }
    }
}
