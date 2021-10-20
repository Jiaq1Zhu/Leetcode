public class Leetcode1549{
    /*
    Given a sequence of non decresing array of integer find the kth missing items
    Two ways First is brute force and second is binary search
    */

    public int burteForce(int[] arr, int k){
        int len = arr.length;
        for(int i = 0;i < len;i++){
            if(arr[i]-i-1)>=k{
                // if current item has in range has enough missing element
                return i+k;
            }
        }
        // there is no missing element inside of the array
        return len+k;
    }

    public int binarySearch(int[] arr, int k){
        int start = 0, end = arr.length;
        //remember the end is out of the bound now;
        while(start < end){
            int mid = (end-start)/2 + start;
            if(arr[mid]-mid - 1 >= k)end = mid;
            else start = mid+1;
        }
        return start + k;
    }

}