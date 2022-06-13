public class Leetcode1893 {
    /**
     * This one is tricky, use difference array to mark if a interval is covered.
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for(int[] interval:ranges){
            diff[interval[0]]++;
            diff[interval[1]+1]--;
        }
        int cur = 0;
        for(int i = 1;i <= 50;i++){
            cur += diff[i];
            if(i >= left && i <= right && cur <= 0)return false;
        }
        return true;
    }
}
