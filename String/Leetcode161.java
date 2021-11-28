public class Leetcode161 {
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        //make sure that t has longer length than s
        if(l1 > l2)return isOneEditDistance(t,s);
        // length differernt make it impossible
        if(l2 - l1 > 1)return false;
        for(int i = 0;i < l1;i++){
            if(s.charAt(i) != t.charAt(i)){
                if(l1 == l2){
                    //if we can just remove this character and check if rest is the same
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{
                    //since t is longer than s, we remove this character from t.
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return l1 + 1 == l2;
    }
}
