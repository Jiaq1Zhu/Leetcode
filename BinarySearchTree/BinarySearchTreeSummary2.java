public class BinarySearchTreeSummary2 {
    //leetcode 98
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode node,Integer min,Integer max){
        if(node == null)return true;
        if(min != null && node.val <= min)return false;
        if(max != null && node.val >= max)return false;
        return helper(node.left,min,node.val) && helper(node.right,node.val,max);
    }

    //leetcode 700
    /**
     * This one is super easy just search in Bst
     */

     public TreeNode searchBST(TreeNode root, int target){
         if(root == null)return null;
         if(root.val == target)return root;
         if(root.val > target)return searchBST(root.left,target);
         if(root.val < target)return searchBST(root.right,target);
         return null;
     }

     // leetcode 701
     public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }else{
            root.right= insertIntoBST(root.right,val);
        }
        return root;
    }

    //leetcdoe 450
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val == key){
            // if the node we want to delete has no variable we just delete it.
            // if has only on child, we just replace it.
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            // if we have both children, we need to find the largest in left child or smallest in right child.
            // lets use right child and find its min. 
            TreeNode minNode = getMin(root.right);
            // remove this node from its previous position
            root.right = deleteNode(root.right,minNode.val);
            // insert this node to replace the node we want to delete.
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        else if(root.val < key){
            //search the node we want to delete in right tree
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key){
            //search the node we want to delete in left tree
            root.left = deleteNode(root.left,key);
        }
        return root;
        
    }
    public TreeNode getMin(TreeNode node){
        while(node.left != null)node= node.left;
        return node;
    }


}
