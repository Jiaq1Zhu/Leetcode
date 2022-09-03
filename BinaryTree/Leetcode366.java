public class Leetcode366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    public int helper(List<List<Integer>> res, TreeNode node){
        // if we hit null, it means we reach -1 level;
        if(node == null)return -1;
        int leftDepth = helper(res,node.left);
        int rightDepth = helper(res,node.right);
        // get current depth;
        int curDepth = Math.max(rightDepth,leftDepth)+1;
        // if current depth is not included in res, create a list for it.
        if(curDepth == res.size())res.add(new ArrayList<>());
        // add value into current depth;
        res.get(curDepth).add(node.val);
        return curDepth;
    }
}
