public class Leetcode21 {
    // Leetcode 21
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy  = new ListNode(-1);
        ListNode p = dummy, p1 = list1, p2 = list2;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }else{
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return dummy.next;
    }
}
