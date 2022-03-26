public class Leetcode567 {
    /**
     * This one is slightly easier.
     * The template is bascilly the same
     * We first expand the right boundary, untile we reach a condition then we shrink(move) left boundry.
     * */
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
}
