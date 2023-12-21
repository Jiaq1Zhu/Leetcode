/**
 * Leetcode1660
 */
public class Leetcode1660 {

    Set<TreeNode> visited = new HashSet<>();
    public TreeNode correctBinaryTree(TreeNode root) {
        if(root == null)return null;
        if(root.right != null && visited.contains(root.right))return null;
        visited.add(root);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        return root;
    }
}