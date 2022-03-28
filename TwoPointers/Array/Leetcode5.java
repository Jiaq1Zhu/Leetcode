public class Leetcode5 {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0;i < s.length();i++){
            String s1 = getPalindrome(s,i,i);
            String s2 = getPalindrome(s,i,i+1);
            res = (res.length() > s1.length())?res:s1;
            res = (res.length() > s2.length())?res:s2;
        }
        return res;
    }
    private String getPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
