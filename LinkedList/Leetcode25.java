public class Leetcode25 {
    /**
     * For this problem we have both iterative solution and recurisve
     */

    public ListNode reverseKGroup(ListNode head,int k){
        ListNode n1 = head, nkPlus = head;
        for(int i = 0;i < k;i++){
            // no enough node to reverse, just return
            if(nkPlus == null)return head;
            nkPlus = nkPlus.next;
        }
        // reverse the first group
        ListNode newHead = reverse(n1, nkPlus);
        // reverse the following group
        n1.next = reverseKGroup(nkPlus, k);
        return newHead;
    }

    /**
     * Lets have a helper function that rever linked list from head to end [left,end)
     * @param head
     * @param end
     * @return
     */
    private ListNode reverse(ListNode head,ListNode end){
        ListNode newHead = null;
        while(head != end){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }


    /**
     * Iterative solution
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;
        while(head != null){
            head = reverseNextK(head,k);
        }
        return dummy.next;
    }
    
    private ListNode reverseNextK(ListNode head, int k){
        ListNode n1 = head.next;
        ListNode nk = head;
        for(int i = 0;i < k;i++){
            nk = nk.next;
            if(nk == null)return null;
        }
        ListNode nkPlus = nk.next;
        ListNode newHead = null;
        ListNode cur = n1;
        while(cur != nkPlus){
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        head.next = newHead;
        n1.next = nkPlus;
        return n1;
    }

    
}
