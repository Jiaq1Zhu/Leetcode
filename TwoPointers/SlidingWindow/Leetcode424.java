public class Leetcode424 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        // create a hash to count ocurrance of each character
        int[] hash = new int[256];
        // init variables
        int left = 0,right = 0, maxCount = 0, maxLength = 0;
        while(right < n){
            // expand right boundary;
            char c = s.charAt(right);
            hash[c]++;
            // update max occurence number in current window
            maxCount = Math.max(maxCount,hash[c]);
            right++;
            // if current window cannot be subsituted make it all the same
            // shrink left boundary
            while(right-left - maxCount>k){
                char d = s.charAt(left);
                hash[d]--;
                left++;
            }
            maxLength = Math.max(maxLength,right-left);
        }
        return maxLength;
    }
}
