public class Leetcode287 {
    public int findDuplicate(int[] nums){
        // The tricky part for this question is to understand the input arr as a linked list
        int fast = 0, slow = 0; 
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);

        slow = 0;
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
