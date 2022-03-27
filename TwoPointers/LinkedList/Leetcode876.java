public class Leetcode876 {
    // Leetcode 876
    /**
     * This one is easy, the fast pointer move twice as fast as slow one.
     * When fast hit the end, the slow is exactlly on the middle.
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
