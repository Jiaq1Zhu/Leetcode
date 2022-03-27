public class Leetcode19 {
    //Leetcode 19
    /**
     * This problem want to the remove the nth node from its end
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode find = findKth(dummy,n+1);
        find.next = find.next.next;
        return dummy.next;
    }
    
    // Let first use this helper function to find the n+1 node fromt the end.
    // It is using fast-slow pointer. Fast point will move k times first, then slow start to move.
    // When fast hit the end, the slow is exactlly what we want.
    public ListNode findKth(ListNode head, int k){
        if(head == null)return null;
        ListNode fast = head;
        for(int i = 0;i< k;i++){
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
