class ValidateBinarySearchTree{
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode node, Integer low, Integer high){
        //reach the null node
        if(node == null)return true;
        int val = node.val;
        //current node is smaller than lower bound
        if(low != null && val <= low)return false;
        //current node is higher than higher bound
        if(high != null && val >= high)return false;
        //recursively handle left and right child node
        //curent val becomes the higher bound for left childs node
        if(!helper(node.left,low,val))return false;
        //current val becomes the lower bound for right childs node
        if(!helper(node.right,val,high))return false;
        return true;
    }
}