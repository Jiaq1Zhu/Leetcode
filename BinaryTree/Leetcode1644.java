class Leetcode1644{
    boolean foundP;
    boolean foundQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = LCA(root,p,q);
        if(foundP && foundQ)return res;
        return null;
    }
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return null;
        TreeNode left = LCA(root.left,p,q);
        TreeNode right = LCA(root.right,p,q);
        if (root == p || root == q) {
            if (root == p) foundP = true;
            if (root == q) foundQ = true;
            return root;
        }
        if(left != null && right != null)return root;
        else if(left == null && right == null)return null;
        else return left != null?left:right;
    }
}