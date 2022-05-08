class Leetcode98:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.check(root.left, None, root.val) and self.check(root.right, root.val, None) 

    def check(self, node:TreeNode, l:int, r:int) -> bool:
        if node is None:
            return True
        if l is None:
            return node.val < r and self.check(node.left, l, node.val) and self.check(node.right, node.val, r)
        if r is None:
            return l < node.val and self.check(node.left, l, node.val) and self.check(node.right, node.val, r)
        return l < node.val < r and self.check(node.left, l, node.val) and self.check(node.right, node.val, r)
