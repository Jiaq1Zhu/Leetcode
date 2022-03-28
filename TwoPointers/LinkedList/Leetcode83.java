public class Leetcode83 {
     // Leetcode 83
    /**
     * This one is basically the same, just we are remove linkedlist
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = head, fast = head;
        while(fast!= null){
            if(fast.val == slow.val){
                fast = fast.next;
            }else{
                slow.next =fast;
                slow = slow.next;
            }
        }
        // remember to do this steps since we do not want the following node.
        slow.next = null;
        return dummy.next;
    }
}
