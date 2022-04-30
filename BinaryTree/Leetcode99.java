public class Leetcode99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root,list);
        TreeNode first = null,second = null;
        for(int i = 1;i < list.size();i++){
            if(list.get(i-1) < list.get(i))continue;
            if(first == null)first = list.get(i-1); 
            second =list.get(i);
        }
        if(first == null)return;
        int temp = first.val;
        first.val =second.val;
        second.val = temp;
    }
    //first we inorder traverse the BST
    // Then we will get a array that only havs two element not in order
    public void inorder(TreeNode root, List<TreeNode> list){
        if(root == null)return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}
