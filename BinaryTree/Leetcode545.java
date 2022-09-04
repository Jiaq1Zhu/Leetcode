public class Leetcode545 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(res == null)return res;
        // deal with root;
        res.add(root.val);
        // left boundary
        leftBoundary(root.left);
        // leaves
        leaves(root.left);
        leaves(root.right);
        // right boundary
        rightBoundary(root.right);
        return res;
    }
    public void leftBoundary(TreeNode node){
        // check if it is null or leaves
        if(node == null || (node.left == null && node.right == null))return;
        res.add(node.val);
        // if not left child, go right;
        if(node.left == null)leftBoundary(node.right);
        // go left
        else leftBoundary(node.left);
    }
    public void rightBoundary(TreeNode node){
        // check if it is null or leaves
        if(node == null || (node.left == null && node.right == null))return;
        // if not right child go left
        if(node.right == null)rightBoundary(node.left);
        // go right;
        else rightBoundary(node.right);
        // add cur after dealing with child
        res.add(node.val);
    }
    public void leaves(TreeNode node){
        // check if is leaves
        if(node == null)return;
        if(node.left == null &&node.right == null){
            res.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
}
}
