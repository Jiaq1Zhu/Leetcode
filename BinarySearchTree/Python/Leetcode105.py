class Leetcode105:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        node = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        preorderLeft = []
        if index > 0: 
            preorderLeft = preorder[1:index + 1]
            node.left = self.buildTree(preorderLeft, inorder[:index])
        if index < len(inorder) - 1: 
            preorderRight = preorder[len(preorderLeft) + 1:]
            node.right = self.buildTree(preorderRight, inorder[index + 1:])
        return node
