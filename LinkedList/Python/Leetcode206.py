class Solution:
    def Leetcode206(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Iterate
        # newHead = None
        # while head:
        #     nextNode = head.next
        #     head.next = newHead
        #     newHead = head
        #     head = nextNode
        # return newHead
        
        # Recursion
        if not head or not head.next:
            return head
        last = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return last
