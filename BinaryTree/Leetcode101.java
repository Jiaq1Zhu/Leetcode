public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return helper(root.left,root.right);
    }

    // we create a helper funtion that check inward and outward direction.
    public boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null)return true;
        if(left != null && right == null)return false;
        if(left == null && right != null)return false;
        if(left.val != right.val)return false;
        boolean leftRes = helper(left.left,right.right);
        boolean rightRes = helper(left.right,right.left);
        return leftRes && rightRes;
    }
}
