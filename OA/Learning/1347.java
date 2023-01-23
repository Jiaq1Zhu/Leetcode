class 1347{
    public int minStep(String s, String t){
        int[] hash = new int[26];
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            hash[c-'a']++;
            hash[d-'a']--;
        }
        int res = 0;
        for(int i:hash){
            if(i > 0)res += i;
        }
        return res;
    }
}