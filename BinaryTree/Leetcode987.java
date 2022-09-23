public class Leetcode987 {
    // because we could have multiple value for same x and y
    Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new HashMap<>();
    int maxX = 0, minX = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = minX; i <= maxX;i++){
            List<Integer> level = new ArrayList<>();
            for(int key:map.get(i).keySet()){
                while(!map.get(i).get(key).isEmpty()){
                    level.add(map.get(i).get(key).poll());
                }
            }
            res.add(new ArrayList<>(level));
        }
        return res;
    }
    // traverse entire tree
    // store value with their x and y position
    public void helper(TreeNode n,int x, int y){
        if(n == null)return;
        maxX = Math.max(maxX,x);
        minX = Math.min(minX,x);
        if(!map.containsKey(x))map.put(x, new TreeMap<Integer,PriorityQueue<Integer>>());
        if(map.get(x).get(y) == null)map.get(x).put(y,new PriorityQueue<>());
        map.get(x).get(y).offer(n.val);
        helper(n.left,x-1,y+1);
        helper(n.right,x+1,y+1);
    }
}
