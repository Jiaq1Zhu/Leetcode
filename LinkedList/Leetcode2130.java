public class Leetcode2130 {
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        int res = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            int value = stack.pop()+cur.val;
            res = Math.max(res,value);
            cur = cur.next;
        }
        return res;
    }
}
