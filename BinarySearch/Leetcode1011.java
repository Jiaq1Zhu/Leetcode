public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        for(int i = 0;i < weights.length;i++){
            left = Math.max(weights[i],left);
        }
        // min value is the max weight on the belt.
        int right = (int)1e6+1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(f(weights,mid) > days)left = mid+1;
            else right = mid-1;
        }
        return left;
    }
    
    public int f(int[] weights, int shipMax){
        int sum = 0;
        int days = 0;
        for(int i = 0;i < weights.length;i++){
            if(sum + weights[i] > shipMax){
                days++;
                sum = 0;
            }
            sum += weights[i];
        }

        if(sum != 0)days++;
        return days;
    }
}
