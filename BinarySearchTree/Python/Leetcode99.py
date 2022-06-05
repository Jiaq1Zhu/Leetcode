class Leetcode99:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        f = s = -1
        tree = []
        self.inorder(root, tree)
        for i in range(1, len(tree)):
            if tree[i-1].val < tree[i].val: continue
            if f == -1: f = i - 1
            s = i
        temp = tree[s].val
        tree[s].val = tree[f].val
        tree[f].val = temp


    
    def inorder(self, node: TreeNode, tree: list) -> None:
        if node is None:
            return
        self.inorder(node.left, tree)
        tree.append(node)
        self.inorder(node.right, tree)
