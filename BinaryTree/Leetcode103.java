public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        boolean zig = false;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                if(node.left != null)q.offer(node.left);
                if(node.right != null)q.offer(node.right);
                list.add(node.val);
            }
            if(zig){
                Collections.reverse(list);
            }
            res.add(list);
            zig = !zig;
        }
        return res;
    }
}
