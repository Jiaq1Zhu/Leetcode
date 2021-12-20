public class UniqueBinarySearchTreeII {
    public List<TreeNode> uniqueBinarySearchTreeII(int n){
        return dfs(1,n);
    }
    public List<TreeNode> dfs(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l > r){
            //base case, there are no node to add, just add null and return;
            res.add(null);
            return res;
        }
        for(int k = l;k <= r;k++){
            //we want to consider every node to be root node
            List<TreeNode> left = dfs(l,k-1);
            List<TreeNode> right = dfs(k+1,r);
            // divide and conquer
            for(int i = 0;i < left.size();i++){
                for(int j = 0;j < right.size();j++){
                    TreeNode root = new TreeNode(k);
                    root.left = left.get(i);
                    root.right = right.get(j);
                    res.add(root);
                }
            }
        }
        return res;
    }
    
}
