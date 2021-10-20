public class Leetcode696{
    /* We need to find how many subarray that contains same number of consecutive 0 and 1 */

    public int countBinary(String s){
        int n = s.length(), prev = 0, cur = 1, res = 0;
        // We if current character is the same as previous one, then we increment cur
        // else we set prev = cur, and cur = 1;
        //if prev is greater or equal to cur we update res;
        for(int i = 1;i < n;i++){
            if(s.charAt(i) == s.charAt(i-1))cur++;
            else{
                prev = cur;
                cur = 1;
                
            }
            if(prev >= cur)res++;
        }
        return res;
    }
}