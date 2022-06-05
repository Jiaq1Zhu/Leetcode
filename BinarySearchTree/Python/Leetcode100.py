class Leetcode100:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right) and p.val == q.val
