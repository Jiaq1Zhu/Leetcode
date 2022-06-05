import heapq
class Leetcode23:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = head = ListNode()
        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, [lists[i].val, i])
        while len(heap) > 0:
            val, i = heapq.heappop(heap)
            head.next = lists[i]
            if lists[i].next:
                lists[i] = lists[i].next
                heapq.heappush(heap, [lists[i].val, i])
            head = head.next
        return dummy.next
