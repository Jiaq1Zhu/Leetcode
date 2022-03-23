public class SerializeBinaryTree {
    // Define some const var
    String SEP = ",";
    String NULL = "#";
    /**
     * In thi file we use inorder traverse to serialize and deserialize a binary tree.
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root,sb);
        return sb.toString();
    }
    
    public void sHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        sHelper(root.left,sb);
        sHelper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s:data.split(SEP)){
            nodes.addLast(s);
        }
        return dHelper(nodes);
    }
    
    public TreeNode dHelper(LinkedList<String> nodes){
        if(nodes.isEmpty())return null;
        String first = nodes.removeFirst();
        if(first.equals(NULL))return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = dHelper(nodes);
        root.right = dHelper(nodes);
        return root;
    }
}
