class Leetcode83:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        def findNext(left, right):
            while right and left.val == right.val:
                right = right.next
            return right
        while slow and slow.next:
            nextNode = findNext(slow, fast)
            slow.next = nextNode
            slow = fast = nextNode
        return head
