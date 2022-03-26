public class Leetcode438 {
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
}
