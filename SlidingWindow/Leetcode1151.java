public class Leetcode1151 {
    public int minSwap(int[] data){
        int total = 0;
        for(int i: data){
            //calculate how many ones we need to get at the end;
            //which is also the window lengh;
            total += i;
        }
        int sum = 0;
        int res = data.length;
        for(int i = 0;i < data.length;i++){
            if(i < total){
                sum += data[i];
                //window size not large enough
            }
            else{
                //large enough
                sum += data[i] - data[i-total];
            }
            res = Math.min(res,total-sum);
        }
        return res;
    }   
}
