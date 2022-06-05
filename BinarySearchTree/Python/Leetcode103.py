from queue import Queue
class Leetcode103:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res
        q = Queue()
        q.put(root)
        flag = True
        while not q.empty():
            levelNode = []
            for i in range(q.qsize()):
                n = q.get()
                if n.left is not None: q.put(n.left)
                if n.right is not None: q.put(n.right)
                levelNode.append(n.val)
            if not flag:
                levelNode = list(reversed(levelNode))
            res.append(levelNode)
            flag = not flag
        return res
