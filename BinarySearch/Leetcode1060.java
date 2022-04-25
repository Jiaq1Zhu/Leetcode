public class Leetcode1060 {
    /**
     * Alright, this one is very similar to 1539, but instead of kth missing number starting at 1, we need to find kth missing number starting at nums[0],
     * so the first thing we need to do is modified previous getMissing()
     */

     /**
      * Everything is pretty same, we need to find the last element that has missing number smaller than k
      * @param nums
      * @param k
      * @return
      */
    public int missingElement(int[] nums,int k){
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            int missing = getMissing(nums, mid);
            if(missing >= k)right = mid-1;
            else left = mid+1;
        }
        //since we starting from the nums[0] we dont need to check conrer case
        return nums[right]+k-getMissing(nums, right);
    }

     public int getMissing(int[] nums, int mid){
         return nums[mid]-nums[0]-mid;
     }
}
