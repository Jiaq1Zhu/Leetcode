class SlidingWindowSummary{

    /**
     * This is a hard problem on Leetcode, we can use sliding window to solve this problem
     * 
     * @param s
     * @param t
     * @return
     */
    

    //Leetcode 567
    /**
     * This one is slightly easier.
     * The template is bascilly the same
     * We first expand the right boundary, untile we reach a condition then we shrink(move) left boundry.
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] hash = new int[256];
        for(char c:s1.toCharArray()){
            hash[c]++;
        }
        int count = s1.length();
        int left = 0,right = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            if(--hash[c] >= 0)count--;
            if(count == 0)return true;
            if(right-left+1 == s1.length()){
                char d = s2.charAt(left);
                if(++hash[d] > 0)count++;
                left++;
            }
            right++;
        }
        return false;
    }

    //Leetcode 438
    /**
     * This one is basically the same as 567 just we need to change the return value
     * 
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[256];
        for(char c:p.toCharArray()){
            need[c]++;
        }
        List<Integer> res= new ArrayList<>();
        int count = p.length();
        int left = 0,right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(--need[c] >= 0)count--;
            if(count == 0)res.add(left);
            if(right-left + 1 == p.length()){
                char d = s.charAt(left);
                if(++need[d] > 0)count++;
                left++;
            }
            right++;
        }
        return res;
    }

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