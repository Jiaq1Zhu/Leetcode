public class Leetcode528 {
    int[] sum;
    Random rand;
    public Solution(int[] w) {
        this.sum = w;
        this.rand = new Random();
        for(int i = 1;i < sum.length;i++){
            sum[i] += sum[i-1];
        }
    }
    
    public int pickIndex() {
        int value = rand.nextInt(sum[sum.length-1])+1;
        int start = 0, end = sum.length-1;
        while(start <= end){
            int mid = (end-start)/2 + start;
            if(sum[mid] == value)return mid;
            if(sum[mid] >= value)end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}
