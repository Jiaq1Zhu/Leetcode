public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root,null,p.val);
    }
    public TreeNode helper(TreeNode root, TreeNode parent, int target){
        // if target is larger than current node val
        // we move to the right of current node,parent will still be parent.
        if(target >root.val)return helper(root.right,parent,target);
        
        // if target is less than current node val
        // we move to the left of current node, parent will be current node;
        else if(target < root.val)return helper(root.left,root,target);
        
        // if the target value is on current node;
        // find the smallest node the right of current node
        if(root.right != null)return findMin(root.right);
        else return parent;
    }
    public TreeNode findMin(TreeNode node){
        if(node.left != null)return findMin(node.left);
        return node;
    }
}
