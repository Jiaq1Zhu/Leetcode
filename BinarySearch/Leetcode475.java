public class Leetcode475 {
    public int findRadius(int[] houses, int[] heaters){
        Arrays.sort(heaters);
        int ans = 0;
        for(int house:houses){
            int left = binarySearch(heaters, house);
            int right = left+1;
            //There are two possible scenrios, cover by the left heater or the right heater.
            int leftDistance = left < 0?Integer.MAX_VALUE:house-heaters[left];
            int rightDistance = right > heaters.length?Integer.MAX_VALUE:heaters[right]-house;
            int curDistance = Math.min(leftDistance,rightDistance);
            ans = Math.max(ans,curDistance);
        }
        return ans;
    }
    private int binarySearch(int[] nums, int target){
        //Binary search the left boundary of current house to find the first heater that is on the left of current house.
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid] == target)right = mid-1;
            else if(nums[mid] < target)left = mid+1;
            else if(nums[mid] > target)right  = mid-1;
        }
        return right;
    }
}
