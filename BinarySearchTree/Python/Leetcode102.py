from queue import Queue
class Leetcode102:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res
        q = Queue()
        q.put(root)
        while not q.empty():
            levelNode = []
            for i in range(q.qsize()):
                n = q.get()
                if n.left is not None: q.put(n.left)
                if n.right is not None: q.put(n.right)
                levelNode.append(n.val)
            res.append(levelNode)
        return res
