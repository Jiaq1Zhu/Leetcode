public class LinkedListSummary {
    /**
     * Leetcode 21
     *
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                node.next = new ListNode(p1.val);
                node = node.next;
                p1 = p1.next;
            }
            else{
                node.next = new ListNode(p2.val);
                node = node.next;
                p2 = p2.next;
            }
        }
        while(p1 != null){
            node.next = new ListNode(p1.val);
            node = node.next;
            p1 = p1.next;
        }
        while(p2 != null){
            node.next = new ListNode(p2.val);
            node = node.next;
            p2 = p2.next;
        }
        return dummy.next;
    } 

    /**
     * Leetcode 23
     * K way merge let's use a heap to do that
     * 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==  0)return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode n:lists){
            if(n != null){
                q.offer(n);
            }
            
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!q.isEmpty()){
            ListNode n = q.poll();
            curr.next = n;
            curr = curr.next;
            if(curr.next != null){
                q.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
