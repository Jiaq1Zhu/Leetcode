public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode n:lists){
            if(n != null)q.offer(n);     
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
            if(curr.next != null)q.offer(curr.next);
        }
        return dummy.next;
        
    }
}
