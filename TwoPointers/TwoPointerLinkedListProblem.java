public class TwoPointerLinkedListProblem {
    
    /**
     * In this file, I will post some solution and analysis using two pointer method in linkedlist problem.
     */

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

    // Leetcode 23
    /**
     * It is k way merge
     *  It is combination 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        PriorityQueue<ListNode> q  = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode n:lists){
            if(n != null){
                q.offer(n);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!q.isEmpty()){
            ListNode n = q.poll();
            head.next = n;
            if(n.next != null){
                q.offer(n.next);
            }
            head = head.next;
        }
        return dummy.next;
    }

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


    //141
    /**
     * Let detect if there is a circle in the linkedlist
     * Fast-slow pointer, if fast reach null-no circle
     * if fast meet the slwo-circle detected
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null)return false;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)return true;
        }
        return false;
    }

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

    //Leetcode 160
    /**
     * This problem is marked as easy. It is an easy problem if you can do it in linear time and O(n) extra space.
     * It is lttle hard if you cannot use extra space.
     * Two pointer is a solution for that
     * I will post several solution on this question including using stack, two pointer 1 and two pointer two
     */
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

