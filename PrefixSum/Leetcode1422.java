/**
 * Leetcode1422
 */
public class Leetcode1422 {

    public int maxScore(String s) {
        int res = Integer.MIN_VALUE;
        int[] prefixZero = new int[s.length()];
        int[] prefixOnes = new int[s.length()];
        // initilize prefixSum array;
        for(int i = 0;i < s.length();i++){
            if(i == 0){
                if(s.charAt(i) == '0')prefixZero[i] = 1;
                else prefixOnes[i] = 1;
            }
            if(s.charAt(i) == '0' && i > 0){
                prefixZero[i] = prefixZero[i-1]+1;
                prefixOnes[i] = prefixOnes[i-1];
            }
            if(s.charAt(i) == '1' && i > 0){
                prefixZero[i] = prefixZero[i-1];
                prefixOnes[i] = prefixOnes[i-1]+1;
            }
        }
        for(int i = 0;i < s.length()-1;i++){
            int leftScore = prefixZero[i];
            int rightScore = prefixOnes[s.length()-1]-prefixOnes[i];
            res = Math.max(res,leftScore+rightScore);
        }
        return res;
    }
}