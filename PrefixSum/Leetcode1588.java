public class Leetcode1588 {
    /*
     * This problem is not a easy problem, it was tagged as easy becase it accept brute force.
     * This is acutally a pure math quetions.
     */
    // regular solution with O(N^2)
    public int sumOddLengthSubarrays(int[] arr) {
        // this init is a little bit different.
        // we need to calculate inclusively so, we made prefix[0] = 0;
        int[] prefixSum = new int[arr.length+1];
        for(int i = 0;i < arr.length;i++){
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        
        int res = 0;
        // then we iterate through every odd length;
        for(int length = 1;length <= arr.length;length += 2){
            // every subarray with odd length sum up together
            for(int i = 0;i+length < prefixSum.length;i++){
                res += prefixSum[i+length]-prefixSum[i];
            }
        }
        return res;
    }

    /**
     * Let dive into the math solution
     * Consider the subarray that contains A[i],
     * we can take 0,1,2..,i elements on the left,
     * from A[0] to A[i],
     * we have i + 1 choices.
     * we can take 0,1,2..,n-1-i elements on the right,
     * from A[i] to A[n-1],
     * we have n - i choices.
     * In total, there are k = (i + 1) * (n - i) subarrays, that contains A[i].
     * And there are (k + 1) / 2 subarrays with odd length, that contains A[i].
     * And there are k / 2 subarrays with even length, that contains A[i].
     * A[i] will be counted ((i + 1) * (n - i) + 1) / 2 times for our question.
     * This solution will result in a O(n) time complexity
     */

    public int sumOddLengthSubarraysMath(int[] A) {
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * A[i];
        }
        return res;
    }
}
