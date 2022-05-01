class Leetcode515{
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return res;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int levelMax = Integer.MIN_VALUE;
            for(int i = 0;i <size;i++){
                TreeNode n = q.poll();
                levelMax = Math.max(levelMax,n.val);
                if(n.left != null)q.offer(n.left);
                if(n.right != null)q.offer(n.right);
            }
            res.add(levelMax);
        }
        return res;
    }
}