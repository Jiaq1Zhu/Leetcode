public class PostorderHardProblem {
    // post order traversal is good when we need to information from both left tree and right tree.
    // Leetcode 1373
    int maxSum;
    public int maxSumBST(TreeNode root){
        /**
         * In this problem, we need to find the maxSum of the a subtree, this subtree must be a BST as well.
         * So we need these information from its subtrees.
         * 1. If it is BST
         * 2. Its min value;
         * 3. Its max value;
         * 4. Its sum
         *  so we create a postorder traverse function to help us do that.
         *  
         */
        maxSum = 0;
        traverse(root);
        return maxSum = 0;
    }
    private int[] traverse(TreeNode root){
        /**
         * int[0]: if current tree is a BST
         * int[1]: The min value
         * int[2]: The max value
         * int[3]: The sum of current BST
         */
        if(root == null){
            // if current root is null
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0}; 
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int[] res = new int[4];
        if(left[0] ==1 && right[0] ==1 && root.val > left[2] && root.val < right[1]){
            res[0] = 1;
            res[1] = Math.min(left[1],root.val);
            res[2] = Math.max(right[2],root.val);
            res[3] = root.val + right[3] + left[3];
            maxSum = Math.max(res[3],maxSum);
        }else{
            res[0] = 0;
        }
        return res;
    }
}
