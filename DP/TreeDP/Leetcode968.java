public class Leetcode968 {
    public int minCameraCover(TreeNode root) {
        int[] res = dp(root);
        return Math.min(res[1], res[2]);
    }

    private int[] dp(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0, 99999 };
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int coveredByParent = left[1] + right[1];
        int coveredByChild = Math.min(left[2] + Math.min(right[1], right[2]), right[2] + Math.min(left[1], left[2]));

        int placedCamera = 1 + Math.min(left[0], Math.min(left[1], left[2]))
                + Math.min(right[0], Math.min(right[1], right[2]));
        return new int[] { coveredByParent, coveredByChild, placedCamera };
    }
}
