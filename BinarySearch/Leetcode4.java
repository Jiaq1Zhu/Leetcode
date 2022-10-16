public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        // if even num, median will be avg of two number
        if(size %2 == 0){
            return (findKth(nums1,0,nums2,0,size/2)+
                   findKth(nums1,0,nums2,0,size/2+1))/2.0;
        }else{
            return findKth(nums1,0,nums2,0,size/2+1);
        }
    }
    // for each time we get rid of the part that does not contain the correct answer.
    public double findKth(int[] nums1, int i , int[] nums2, int j ,int k){
        // if num1 is running out
        if(i >= nums1.length){
            return nums2[j+k-1];
        }
        // if num2 is running out
        if(j >= nums2.length){
            return nums1[i+k-1];
        }
        // if we reach the last step
        if(k == 1){
            return Math.min(nums1[i],nums2[j]);
        }
        // initialize the first value;
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        // get mid in num1
        if(i+k/2-1 < nums1.length){
            mid1 = nums1[i+k/2-1];
        }
        // get mid in num2;
        if(j + k/2-1 < nums2.length){
            mid2 = nums2[j+k/2-1];
        }
        // if mid1 < mid2, it means that the part before mid1 does not contain element we want.
        if(mid1 < mid2){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }else{
            // for mid2 is vice versa.
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }
    }
}
