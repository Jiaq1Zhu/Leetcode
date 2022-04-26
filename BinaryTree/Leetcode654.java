public class Leetcode654 {
    //leetcode 654
    public TreeNode constructMaximumBinaryTree(int[] nums){
        // this one is a little bit tricky.
        /* In this questi  on, we need to first select the maximum number and its index, then we seperate the list into to part and do same process recursively. */
        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] nums, int start, int end){
        //this is a helper function
        if(start > end)return null;
        int index = -1, maxVal = Integer.MIN_VALUE;
        for(int i= start;i <= end;i++){
            if(nums[i] > maxVal){
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums,start,index-1);
        root.right = build(nums,index+1,end);
        return root;
    }
}
