class Leetcode109:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        def findMid(start, end):
            slow = fast = start
            while fast != end and fast.next != end:
                slow = slow.next
                fast = fast.next.next
            return slow
        
        def buildTree(start, end):
            if start == end:
                return None
            mid = findMid(start, end)
            root = TreeNode(mid.val)
            root.left = buildTree(start, mid)
            root.right = buildTree(mid.next, end)
            return root
        
        return buildTree(head, None)
