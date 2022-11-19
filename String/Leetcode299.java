public class Leetcode299 {
    public String getHint(String secret, String guess){
        int bulls = 0;
        int cows = 0;
        int[] counter = new int[10];
        for(int i = 0;i < secret.length();i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i-'0');
            if(s == g)bulls++;
            else{
                if(counter[s] < 0)cows++;
                if(counter[g] > 0)cows++;
                counter[s]++;
                counter[g]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(bulls)).append("A").append(String.valueOf(cows)).append("B");
        return sb.toString();

    }
}
