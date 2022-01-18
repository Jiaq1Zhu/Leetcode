public class BinarySearchTemplate {
    public int binarySearchOnElement(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (right-left)/2+left;
            if(nums[mid] == target)return mid;
            else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }
        }
        return -1;
    }
    public int binarySearchOnLeftBoundary(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (right-left)/2+left;
            if(nums[mid] == target){
                right = mid-1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
        }
        if(left >= nums.length || nums[left] != target)return -1;
        return left;
    }

    public int binarySearchOnRightBoundary(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (right- left)/2 + left;
            if(nums[mid] == target){
                left = mid+1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
        }
        if(right < 0 || nums[right] != target)return -1;
        return right;
    }


}
