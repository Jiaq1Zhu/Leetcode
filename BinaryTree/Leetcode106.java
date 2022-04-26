import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] postorder, int[] inorder){
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,postorder.length-1,postorder,0,inorder.length-1,inorder);
    }
    private TreeNode helper(int pStart, int pEnd, int[] postorder,int iStart,int iEnd, int[] inorder){
        if(pStart > pEnd || iStart > iEnd)return null;
        int index = map.get(postorder[pEnd]);
        int leftNum = index-iStart;
        TreeNode root = new TreeNode(postorder[pEnd]);
        root.left = helper(pStart,pStart+leftNum-1,postorder,iStart,index,inorder);
        root.right = helper(pStart+leftNum,pEnd-1,postorder,index+1,iEnd,inorder);
        return root;
    }
}
