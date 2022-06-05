public class Leetcode111 {
    /**
     * This problem have two solutions.
     * 1.bfs
     * 2.Recursive
     *  
     */ 

    public int minDepth(TreeNode root) {
        /**
         * For bfs, we do binary tree level order traversa.
         * Once we encounter a leaf node we return current depth
         */
        int depth = 1;
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i <size;i++){
                TreeNode n = q.poll();
                if(n.left == null && n.right == null)return depth;
                if(n.left != null)q.offer(n.left);
                if(n.right != null)q.offer(n.right);
            }
            depth++;
        }
        return 0;
    }
    
    public int minDepth2(TreeNode root){
        /**
         * For recursive method, we use a helper function to return the result we calculate from children nodes
         * 
         */
        if(root == null)return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if(root.left == null)return right+1;
        if(root.right == null)return left+1;
        return Math.min(left,right)+1;
    }
    
}
