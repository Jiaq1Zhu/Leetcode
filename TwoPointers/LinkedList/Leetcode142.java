public class Leetcode142 {
    // Leetcode 142
    // now we need to find the entry point of the circle.
    public ListNode detectCycle(ListNode head) {
        if(head == null)return null;
        ListNode fast = head,slow = head;
        while(fast.next!=null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)break;
        }
        if(fast.next == null || fast.next.next == null)return null;
        // this part is tricky.
        // I will just skip the prove process and tell the truth.
        // The travel distance of the current point to entry point is excatly the same as a head point to entry point.
        // So, if we can set a point to the head, when i met with fast with same stride. That is the entry point.
        ListNode p = head;
        while(p != fast){
            fast = fast.next;
            p = p.next;
        }
        return p;
    }
}
