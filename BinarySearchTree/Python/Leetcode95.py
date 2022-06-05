class Leetcode95:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        return self.buildTrees(range(1, n+1))
    
    def buildTrees(self, nodes: list) -> List[Optional[TreeNode]]:
        if len(nodes) == 0:
            return [None,]
        res = []
        for i, num in enumerate(nodes):
            left = nodes[:i]
            right = nodes[i+1:]
            leftTree = self.buildTrees(left)
            rightTree = self.buildTrees(right)
            for l in leftTree:
                for r in rightTree:
                    root = TreeNode(num)
                    root.left = l
                    root.right = r
                    res.append(root)
        return res
