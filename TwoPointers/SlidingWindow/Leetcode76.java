public class Leetcode76 {
    public String minWindow(String s, String t) {
        int[] window = new int[256];
        int[] need = new int[256];
        int lengthT = t.length();
        int lengthS = s.length();
        for(int i = 0;i < lengthT;i++){
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int valid = 0;
        String res = "";

        while(right < lengthS){
            char c = s.charAt(right);
            // when we encounter a character that is in what we need
            if(need[c] > 0){
                // when we still need more of it.
                if(++window[c] <= need[c])valid++;
            }
            //we current window has enough character
            while(valid == lengthT){
                //update interval and res;
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    res = s.substring(left,right+1);
                }
                char d = s.charAt(left);
                // if we are about to remove a character in what we want.
                if(need[d] > 0){
                    //
                    if(--window[d] < need[d])valid--;
                }
                //shrink left bound
                left++;
            }
            // expand right bound
            right++;
        }
        return res;
    }
}
