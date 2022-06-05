class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder) == 0:
            return None
        node = TreeNode(postorder[-1])
        index = inorder.index(postorder[-1])
        postorderLeft = []
        if index > 0: 
            postorderLeft = postorder[0:index]
            node.left = self.buildTree(inorder[:index], postorderLeft)
        if index < len(inorder) - 1: 
            postorderRight = postorder[len(postorderLeft):-1]
            node.right = self.buildTree(inorder[index + 1:], postorderRight)
        return node
