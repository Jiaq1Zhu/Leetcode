public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * Two pointer solution one
         * We are acutally concat two string together.
         * We are actually go though the a chained linkedList
         * When pointer1 reach the end, it will enter headB
         * When pointer2 reach the end, it will enter headA
         * When they are the same, that is the intersection.
         * This solution is super tricky. I will say I could not figure it out by myself.
         */
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }  
        }
        return p1;
    }
}
