public class Leetcode3 {
    // leetcode3
    /**
     * This one is differnt but it's esailer
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;
        int res = 0;
        int[] hash = new int[256];
        while(right < s.length()){
            char c = s.charAt(right);
            //expand right boundry
            right++;
            hash[c]++;
            // found duplicate shrink left window
            while(hash[c] > 1){
                char d = s.charAt(left);
                hash[d]--;
                left++;
            }
            // update result;
            res = Math.max(res,right-left);
        }
        return res;
    }
}
