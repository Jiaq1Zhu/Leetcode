class Leetcode25:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        guard = dummy
        while head:
            start = head
            for i in range(k-1):
                head = head.next
                if not head:
                    return dummy.next
            for i in range(k-1):
                nextNode = start.next
                start.next = nextNode.next
                nextNode.next = guard.next
                guard.next = nextNode
            guard = start
            head = start.next
        return dummy.next
