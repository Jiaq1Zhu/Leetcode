public class Leetcode124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        int sum = root.val + left + right;
        res = Math.max(res,sum);
        return Math.max(left+root.val,right+root.val);
    }
}
