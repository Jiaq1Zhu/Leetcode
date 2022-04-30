public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    
    // using this helper function we make sure that current not is in BST, and update the range for its children.
    public boolean helper(TreeNode root,Integer min,Integer max){
        if(root == null)return true;
        if(min != null && root.val <= min)return false;
        if(max != null && root.val >= max)return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}
