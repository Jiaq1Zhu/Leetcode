public class Leetcode530 {
    /**
     * We need to find minimum abs diff between two nodes in the BST
     * We can use a inorder, since inorder traversal is the sorted list of this bst. And then we can compare the difference
     */
    TreeNode prev;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root){
        if(root = null)return;
        inorder(root.left);
        if(prev != null){
            res = Math.min(res,root.val-prev.val);
        }
        prev = root;
        inorder(root.right);
    }
    
}
