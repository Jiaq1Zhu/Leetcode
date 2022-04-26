public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        // check null case
        if(nums== null || nums.length == 0)return -1;
        // check if the head or tail is peak
        if(nums.length == 1)return 0;
        if(nums[0] > nums[1])return 0;
        if(nums[nums.length-1] > nums[nums.length-2])return nums.length-1;
        // search range does not contain boundary
        int left = 1;
        int right = nums.length-2;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid])return mid;
            else if(nums[mid-1] < nums[mid])left = mid+1;
            else right = mid-1;
        }
        //dummy return 
        return -1;  
    }
}
