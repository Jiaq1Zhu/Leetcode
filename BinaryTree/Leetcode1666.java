public class Leetcode1666 {
    Node oriRoot;
    public Node flipBinaryTree(Node root, Node leaf) {
        oriRoot = root;
        return helper(leaf,null);
    }

    public Node helper(Node node,Node newParent){
        Node oldParent = node.parent;
        node.parent = newParent;
        if(node.left == newParent)node.left = null;
        if(node.right == newParent)node.right = null;

        if(node == oriRoot)return node;

        if(node.left != null)node.right = node.left;
        node.left = helper(oldParent,node);
        return node;
    }
}
