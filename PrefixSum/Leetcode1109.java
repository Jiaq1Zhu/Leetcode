public class Leetcode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] preSum = new int[n];
        for(int[] booking:bookings){
            int i = booking[0];
            int j = booking[1];
            int val = booking[2];
            preSum[i-1] += val;
            if(j < n){
                preSum[j] -= val;
            }
        }
        for(int i = 1;i < n;i++){
            preSum[i] += preSum[i-1];
        }
        return preSum;
    }
}
