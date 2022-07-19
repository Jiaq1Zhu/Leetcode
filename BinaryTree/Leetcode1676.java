public class Leetcode1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer>set = new HashSet<>();
        for(TreeNode node:nodes){
            set.add(node.val);
        }
        return LCA(root,set);
        
    }
    
    public TreeNode LCA(TreeNode root, HashSet<Integer> set){
        if(root == null)return null;
        if(set.contains(root.val)){
            return root;
        }
        TreeNode left = LCA(root.left,set);
        TreeNode right = LCA(root.right,set);
        if(left != null && right != null)return root;
        return left == null?right:left;
        
    }
}
