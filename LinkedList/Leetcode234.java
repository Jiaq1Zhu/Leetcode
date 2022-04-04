public class Leetcode234 {
    /**
     * The stack interpertation is simple, but we need to iterate the entire linkedlist twice
     * For this solution, we create a helper fucntion to reverse
     * Then we use fast-slow pointer to find the mid point of the linkedlist
     * Then we reverse that part.
     * Then we can find out the answer.
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)slow = slow.next;
        ListNode cur = head;
        fast = reverse(slow);
        while(fast != null){
            if(cur.val != fast.val)return false;
            cur = cur.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
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
