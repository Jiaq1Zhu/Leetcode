public class Leetcode543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root){
        if(root == null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right;
        res = Math.max(res,sum);
        return Math.max(left+1,right+1);
    }
}
