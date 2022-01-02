public class CountUnivalueSubtrees {
    int count = 0;
    public boolean isUniNode(TreeNode node){
        if(node.left == null && node.right){
            count++;
            return true;
        }
        boolean isUni = true;
        if(node.left != null){
            isUni = isUni && isUniNode(node.left) && node.left.val == node.val;
        }
        if(node.right != null){
            isUni = isUni && isUniNode(node.right) && node.right.val == node.val;
        }
        if(!isUni)return false;
        count++;
        return true;
    }

    public int countUni(TreeNode root){
        if(root == null)return 0;
        isUniNode(root);
        return count;
    }
}
