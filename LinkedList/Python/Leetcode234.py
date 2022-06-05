class Leetcode234:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        def reverse(node):
            newHead = None
            while node:
                nextNode = node.next
                node.next = newHead
                newHead = node
                node = nextNode
            return newHead
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        reversedNode = reverse(slow)
        while reversedNode:
            if head.val != reversedNode.val:
                return False
            head = head.next
            reversedNode = reversedNode.next
        return True
