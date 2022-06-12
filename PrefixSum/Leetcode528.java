public class Leetcode528 {
    /**
     * This problem is very tricky, you need to knwo both binary search and prefix sum array
     */
    int[] sum;
    Random rand;
    public Solution(int[] w) {
        this.sum = w;
        this.rand = new Random();
        /**
         * In the constructor we create a prefix sum array to mimic the selection with weight
         */
        for(int i = 1;i < sum.length;i++){
            sum[i] += sum[i-1];
        }
    }
    
    public int pickIndex() {
        /**
         * the random value generate range should be [1,sum[sum.length-1]];
         */
        int value = rand.nextInt(sum[sum.length-1])+1;
        int start = 0, end = sum.length-1;
        /** 
         * Then we use binary search to find the first value that is larger than our target value.
         * the index of the this element is the number we picked.
         */
        while(start <= end){
            int mid = (end-start)/2 + start;
            if(sum[mid] == value)return mid;
            if(sum[mid] >= value)end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}
