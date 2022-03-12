public class BinarySearchTreeSummary {
     class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /** We should probably get three types of traversal in the first place, that is the start of everything here */

    public static void preorder(TreeNode root, List<Integer> list){
        if(root == null)return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    public static void inorder(TreeNode root, List<Integer> list){
        if(root == null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public static void postorder(TreeNode root, List<Integer> list){
        if(root == null)return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }


    // leetcode 230
    public static int kthSmallest(TreeNode root){
        /**
         * For this problem, the inorder traversal is the correct order of a binary search tree
         * So we can just reconstruct a sorted list and return the kth smallest element.
         */
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list.get(k-1);
    }

    // leetcode 538- 1038 there are the same
    int Sum538 = 0;
    public static TreeNode converBST(TreeNode root){
        /**
         * This questions requires us to make the val of current tree equals the sum of all node on its right plus its own value;
         * So, it is another recursive method. 
         * We creaet a global variable sum, and and update it and current value with sequence of root.right->root->root.left;
         */
        if(root == null)return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

    // Leetcode 285
    // this quesiton has very little code but hard to go through all the possible cases.
    // Leetcode 510 as well.
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        /**
         * In this problem we need to find the successor of p
         * Lets do this in a recursive method.
         * 
         */
        if(root == null)return null;
        if(root.val <= p.val){
            /**
             * case0:
             * In this case, it's successor must be in right subtree or none
             */
            return inorderSuccessor(root.right,p);
        }else{
            /**
             * In this case, we try to find it in leftsubtree, let just lis the case out：
             * case1: All leftNode is greater than p, then we just need to return the leftest child.
             * case2: We find a node that node.val <= p, then we go to case0, if case0 return a null, that will make our function return last node that is greater than p
             * which is what we want.
             * or just our root since root is also qualify for that.
             */
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null)?left:root;
        }

    }

    // Leetcode 510
    public Node inorderSuccessorII(Node node) {
        // first case is to find its inorder successor is to find the minimum value in this right subtree.
        if(node.right != null){
            node = node.right;
            while(node.left != null)node = node.left;
            return node;
        }
        //second case is to find its inorder successor in its parent or grandparent.
        //if the current node is the right node of parent, it means that we are still larger than current parent.
        // so the stop condition is that current node is left child of parent, then we just return its parent.
        while(node.parent != null && node == node.parent.right)node = node.parent;
        return node.parent;
        
    }


}
