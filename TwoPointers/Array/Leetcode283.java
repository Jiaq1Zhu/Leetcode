public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)return;
        int fast = 0,slow = 0;
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
}
