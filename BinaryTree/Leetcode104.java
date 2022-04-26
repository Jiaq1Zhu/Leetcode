public class Leetcode104 {
    public static int maxDepth(TreeNode root){
        //leetcode 104
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
