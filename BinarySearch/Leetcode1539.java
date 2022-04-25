public class Leetcode1539 {
    //Kth Missing Positive Number
    //this is the reason why I failed meta. I shall remember this in my life.
    /**
     * 1. According to the application of binary search, it can be used on monotonous array or a monotonus function
     * so, in this questions, besides the arr, is there anything else that is monotonus? 
     * Yes, the number of missing items will also increase with index.
     * The more elements you explored, the more missing item you will possibly get.
     * @param arr
     * @param k
     * @return
     */
    public int findKthPositive(int[] arr, int k){
        /**
         * 3. Okey, now what we need to find, is to find the last element that has missing number less than k, let's say it is n
         * This means that k must lay between arr[n] and arr[n+1]
         * 
         */
        int left = 0,right = arr.length-1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            int missing = getMissing(arr, mid);

            if(missing <= k){
                // in this case, current element has more missing item than we need, we shrink right boundary
                right = mid-1;
            }else{
                // in this case current element has not enough, wo we have to shinrk left boundary
                left = mid+1;
            }
        }
        // in this case, if left == 0,then right == -1
        // if the first element that has more missing than k is 0
        // this means 1-k is missing in the before arr[0];
        // we can directly return k;
        if(left < 1)return k;
        // this means k is located between arr[right]---arr[left];
        // let's first found how many missing item is before arr[right]
        // we just add it up.
        return arr[right] + k - getMissing(arr, right);
    }

    /**
     * 2. So, lets first implement this monotonus function
     */

     public int getMissing(int[] arr, int mid){
         /**
          * Since we are calculating missing number from 1, so we need extract the number at index mid, use it to minus (mid+1) to get how many item was missing
          * from leftmost index to mid index.
          */
          return arr[mid]-mid-1;
     }
}
