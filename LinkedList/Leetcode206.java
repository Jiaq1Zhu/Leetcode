class Leetcode206{
    /**
     * Alright, we gonna have two solutions, for both iterative and recursive.
     */
    public ListNode reverse(ListNode head){
        /**
         *  Recursive one
         */
        if(head == null || head.next == null)return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList(ListNode head){
        if(head == null)return null;
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}