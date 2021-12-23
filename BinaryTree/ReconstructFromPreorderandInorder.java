import java.util.HashMap;
import java.util.Map;

public class ReconstructFromPreorderandInorder {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode reconstruct(int[] preorder, int[] inorder){
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,preorder.length-1,preorder,0,inorder.length-1,inorder);

    }
    public TreeNode helper(int pStart, int pEnd, int[] preorder, int iStart, int iEnd, int[] inorder){
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }
        int index = map.get(preorder[pStart]);
        int leftNum = index-iStart; 
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = helper(pStart+1, pStart+leftNum-1,preorder,iStart,index,inorder);
        root.right = helper(pStart+leftNum,pEnd,preorder,index+1,iEnd,inorder);
        return root;
    }
}
