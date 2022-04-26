public class Leetcode312 {
    /**
     * Binary Tree Vertical Order Traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        // we use a tree map to map the nodes and their vertical distance
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        // here we store pair instead of nodes, we can store distance and nodes
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Pair<TreeNode,Integer> p = q.poll();
                TreeNode curNode = p.getKey();
                int dist = p.getValue();
                List<Integer> list = map.getOrDefault(dist,new ArrayList<>());
                list.add(curNode.val);
                map.put(dist,list);
                if(curNode.left != null)q.offer(new Pair(curNode.left,dist-1));
                if(curNode.right != null)q.offer(new Pair(curNode.right,dist+1));
            }
        }
        return new ArrayList<>(map.values());
    }
    
}
