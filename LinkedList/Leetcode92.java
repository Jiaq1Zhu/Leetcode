public class Leetcode92 {
    
    /**
     * It is very smiliar to reverse the entire linked list, but instead we need to reverse a interval.
     * First we need to create a reveseN function that reverse N node from  head node
     */
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n){
        if(n == 1){
            // find the last node we need to reverse;
            // successor need to be recoreded.
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    /**
     * For this problem, we can also have a iterative solution
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode guard = dummy;
        // guard node is the node that is before the node we want to reverse
        for(int i = 1;i <left;i++){
            guard = guard.next;
        }
        // for here we use a head insertion method, let see an example
        /**
         * 1->2->3-4->5->6
         * we want to reverse 2-5
         * we first pull 3 and insert between 1 and 2
         * 1->3->2->4-5->6
         * then we get 4 and insert between 1 and 3
         * 1->4->3-2->5->6
         * then we do five.
         */
        ListNode cur = guard.next;
        for(int i = left;i <right;i++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = guard.next;
            guard.next = next;
        }
        return dummy.next;
    }
}
