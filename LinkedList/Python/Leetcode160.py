class Leetcode160:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        pointerA, pointerB = headA, headB
        def traverse(a, b):
            while a and b:
                a = a.next
                b = b.next
            if not a:
                a = headB
            else:
                b = headA
            return a, b
        for i in range(2):
            pointerA, pointerB = traverse(pointerA, pointerB)
        while pointerA != pointerB:
            pointerA = pointerA.next
            pointerB = pointerB.next
        if not pointerA:
            return None
        else: return pointerA
