public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1,right = (int)1e9+1;
        while(left <= right){
            int mid = (right-left)/2+ left;
            if(f(piles,mid) <= h)right = mid-1;
            else if(f(piles,mid) < h)right = mid-1;
            else left = mid+1;
        }
        return left;
    }

    /***
     *  f is a function that returns value that increase with x value decrease.
     * @param piles
     * @param x
     * @return
     */
    
    private int f(int[] piles, int x){
        int hours = 0;
        for(int i = 0;i < piles.length;i++){
            hours += piles[i]/x;
            if(piles[i]%x > 0)hours++;
        }
        return hours;
    }


}
