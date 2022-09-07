public class Leetcode1567 {
    public int getMaxLen(int[] nums){
        // this problem is dp but does not have dp array.
        // pos is current positive len for current index, negative is for negative len
        int res = 0;
        int pos = 0, neg = 0;
        for(int x:nums){
            if(x == 0){
                // if current index has value 0, clear pos len and neg len
                pos = 0;
                neg = 0;
            }
            else if(x > 0){
                // if we have a positive number, add positive
                pos++;
                // if we have not encounter any negative number, stay with 0
                // if we have neg len, add it.
                neg = neg == 0?0:neg+1;
            }else{
                // if we have a negative number. 
                int temp = pos;
                // if we have no negative number before, clear pos to 0
                // if we have negative len, swap and add current index(1);
                pos = neg == 0?0:neg+1;
                // negative len should be previous positive len plus current index(1)
                neg = temp+1;
            }
            // update longest positive length
            res = Math.max(res,pos);
        }
        return res;
    }
}
