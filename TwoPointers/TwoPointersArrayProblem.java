class TwoPointersArrayProblem{
    /**
     * In this file I will mainly focus on two pointer algorithm application in array problems.
     * There are generally two types of two pointers problems.
     * Fast and slow, left and right;
     */
    //Leetcode 26
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

    // Leetcode 83
    /**
     * This one is basically the same, just we are remove linkedlist
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = head, fast = head;
        while(fast!= null){
            if(fast.val == slow.val){
                fast = fast.next;
            }else{
                slow.next =fast;
                slow = slow.next;
            }
        }
        // remember to do this steps since we do not want the following node.
        slow.next = null;
        return dummy.next;
    }

    // Leetcode 27
    /**
     * This problem ask you to remove certain element in place(O(1) extra space)
     */
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)return 0;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    // Leetcode 283
    /**
     * This problem ask you to move all the zeros to the end.
     * This is the same as the previous question ,remove all zeros and make res of them zero.
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)return;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while(slow < nums.length){
            nums[slow++] = 0;
        }
    }


    /**
     * Most of the right left pointer are doing reverse, palindrome, binarySearch
     */

     // Let detect a palindrome
     public boolean isPalindrome(String s){
         int left = 0, right = s.length()-1;
         while(left < right){
             if(s.charAt(left++) != s.charAt(right--))return false;
         }
         return true;
     }


     // Leetcode 5
     public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0;i < s.length();i++){
            String s1 = isPalindrome(s,i,i);
            String s2 = isPalindrome(s,i,i+1);
            res = res.length()> s1.length()?res:s1;
            res = res.length()> s2.length()?res:s2;
        }
        return res;
    }
    // we first create this function that we return a palindrome that center at left(even), or left +1(odd) situation.
    public String isPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}