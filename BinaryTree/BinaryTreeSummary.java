class BinarySearchTreeSummary{
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

    public static int maxDepth(TreeNode root){
        //leetcode 104
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
    // Leetcode124
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        int sum = root.val + left + right;
        res = Math.max(res,sum);
        return Math.max(left+root.val,right+root.val);
    }


    //leetcode543
    int res1 = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper1(root);
        return res1;
    }
    private int helper1(TreeNode root){
        if(root == null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right;
        res1 = Math.max(res1,sum);
        return Math.max(left+1,right+1);
    }

    //leetcode 654
    public TreeNode constructMaximumBinaryTree(int[] nums){
        // this one is a little bit tricky.
        /* In this questi  on, we need to first select the maximum number and its index, then we seperate the list into to part and do same process recursively. */
        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] nums, int start, int end){
        //this is a helper function
        if(start > end)return null;
        int index = -1, maxVal = Integer.MIN_VALUE;
        for(int i= start;i <= end;i++){
            if(nums[i] > maxVal){
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums,start,index-1);
        root.right = build(nums,index+1,end);
        return root;
    }

    //leetcode 105
    /** For this type of questions we need to remember the difference of three types of travesal
     * preorder: root,left,right;
     * inorder :left,root.right;
     * postorder left,right,root;
     */
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //we map the index and value in inorder, so we can easily find the part that is belong to the left, and the right based on root index.
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper2(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode helper2(int[] preorder, int pStart, int pEnd, int[] inorder,int iStart,int iEnd){
        if(pStart > pEnd || iStart > iEnd)return null;
        int index = map.get(preorder[pStart]);
        int leftSum = index-iStart;
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = helper2(preorder,pStart+1,pStart+leftSum,inorder,iStart,index);
        root.right = helper2(preorder,pStart+leftSum+1,pEnd,inorder,index+1,pEnd);
        return root;
        
    }
// leetcode 106 
/**
 * This one is basiclly the same except that we change preorder to postorder
 * 
 */
Map<Integer,Integer> map1 = new HashMap<>();
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        for(int i = 0;i <inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper3(0,postorder.length-1,postorder,0,inorder.length-1,inorder);
    }
    private TreeNode helper3(int pStart, int pEnd, int[] postorder,int iStart, int iEnd, int[] inorder){
        if(pStart >pEnd|| iStart > iEnd)return null;
        int index = map.get(postorder[pEnd]);
        int leftNum = index-iStart;
        TreeNode root = new TreeNode(postorder[pEnd]);
        root.left = helper3(pStart,pStart+leftNum-1,postorder,iStart,index,inorder);
        root.right = helper3(pStart+leftNum,pEnd-1,postorder,index+1,iEnd,inorder);
        return root;
    }

// leetcode 889
/**
 * This one is just preorder and postorder, in this quesiotn, we are not required to reconstruct the original tree.
 * We just need to return one of the possible tree
 * So, we can take the one preorder[preStart] as the root, and preorder[preStart+1] as the root.left value;
 * wen know that the first one in preorder is the same as last one in postorder
 * So we need to find the index of the leftVal in postorder, before that we consider it as the left size ,then everything is basiclly the same.
 */
Map<Integer,Integer> map3 = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i = 0;i < postorder.length;i++){
            map.put(postorder[i],i);
        }
        return build3(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build3(int[] preorder,int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd || postStart > postEnd)return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int leftRoot = preorder[preStart+1];
        int index = map3.get(leftRoot);
        int leftSize = index-postStart+1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build3(preorder,preStart+1,preStart+leftSize,postorder,postStart,index);
        root.right = build3(preorder,preStart+leftSize+1,preEnd,postorder,index+1,postEnd-1);
        return root;
    }

    // leetcode 652
/**
 * Find dupulicate subtree in a given tree and add them into a list
 * This one we use create a String of inorder traversal as the hash value.
 */

public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String,List<TreeNode>> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    hash(root,map);
    for(List<TreeNode> group:map.values()){
        if(group.size() > 1){
            res.add(group.get(0));
        }
    }
    return res;
}

public String hash(TreeNode node, Map<String,List<TreeNode>> map){
    if(node == null)return "";
    String hashVal = "("+hash(node.left,map)+node.val+hash(node.right,map)+")";
    if(!map.containsKey(hashVal))map.put(hashVal,new ArrayList<>());
    map.get(hashVal).add(node);
    return hashVal;
}
    
}



