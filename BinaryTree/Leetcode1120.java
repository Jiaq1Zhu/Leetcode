package BinaryTree;

public class Leetcode1120 {
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
    double max;
    class returnNode{
        int nodeNum;
        int sum;
        public returnNode(int nodeNum,int sum){
            this.nodeNum = nodeNum;
            this.sum = sum;
        }
    }
    public returnNode helper(TreeNode node){
        if(node == null)return new returnNode(0,0);
        returnNode left = helper(node.left);
        returnNode right = helper(node.right);
        int sum = left.sum + right.sum+node.val;
        int nodeNum = left.nodeNum + right.nodeNum+1;
        double curAvg = (double)(sum)/nodeNum;
        this.max = Math.max(max,curAvg);
        return new returnNode(nodeNum,sum);
    }
    public double maximumAverageSubtree(TreeNode root) {
        this.max = 0.0;
        helper(root);
        return max;
    }
}
}
