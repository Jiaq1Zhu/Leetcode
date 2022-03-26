public class Leetcode1151 {
    public int minSwaps(int[] data) {
        int total = 0;
        for(int i:data){
            total += i;
        }
        // total is the window length we are looking for
        int curr = 0;
        int res = total;
        int left = 0,right = 0;
        while(right < data.length){
            curr += data[right];
            if(right-left+1 == total){
                //start to shrink the leftside
                res = Math.min(total-curr,res);
                curr -= data[left];
                left++;
            }
            right++;
        }
        return res;
    }
}
