public class Leetcode26 {
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
        // plus 1 since the testcase is using substring()
        return slow+1;
    }
}
