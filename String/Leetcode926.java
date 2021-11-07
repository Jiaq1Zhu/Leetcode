public class Leetcode926 {
    public int minimumflip(String s){
        int flips = 0, int cnt = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '0'){
                flips++;
            }else{
                cnt++;
            }
            flips = Math.min(flips,cnt);
        }
        return flips;
    }
}
