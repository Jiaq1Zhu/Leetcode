class Leetcode92:
    succ = None
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        # Iterate
        # dummy = ListNode(0, head)
        # guard = dummy
        # for i in range(left-1):
        #     guard = guard.next
        # cur = guard.next
        # for i in range(left, right):
        #     nextNode = cur.next
        #     cur.next = nextNode.next
        #     nextNode.next = guard.next
        #     guard.next = nextNode
        # return dummy.next
        
        # Recursion
        global succ
        if left != 1:
            head.next = self.reverseBetween(head.next, left-1, right-1)
            return head
        if right == 1:
            succ = head.next
            return head
        last = self.reverseBetween(head.next, left, right-1)
        head.next.next = head
        head.next = succ
        return last
