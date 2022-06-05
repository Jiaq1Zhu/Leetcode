class Leetcode104:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        else: return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
