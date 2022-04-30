public class Leetcode298 {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root,0,Integer.MIN_VALUE);
        return maxLen;
    }
    // pass current len and parent val to its children
    public void traverse(TreeNode node, int len, int parentVal){
        if(node == null)return;
        
        if(parentVal + 1 == node.val)len++;
        else len = 1;
        maxLen = Math.max(maxLen,len);
        traverse(node.left,len,node.val);
        traverse(node.right,len,node.val);
    }
}
