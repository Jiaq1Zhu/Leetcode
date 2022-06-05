class Leetcode101:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.checkSymmetric(root, root)

    def checkSymmetric(self, l: TreeNode, r: TreeNode) -> bool:
        if l is None and r is None:
            return True
        elif l is None or r is None:
            return False
        else: return l.val == r.val and self.checkSymmetric(l.left, r.right) and self.checkSymmetric(l.right, r.left)
