public class Leetcode272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // we first traverse the entire tree and get val;
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        // we sort the value by its distance to target
        Collections.sort(res,(a,b)->Math.abs(a-target)<Math.abs(b-target)?-1:1);
        // then we just return the sublist with len k;
        return res.subList(0,k);
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
