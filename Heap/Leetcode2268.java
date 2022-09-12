public class Leetcode2268 {
    public int minimumKeypresses(String s) {
        int[] freq = new int[26];
        // check the frequency of each character
        for(int i = 0;i < s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        // the character with most frequency should have least press time
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i = 0;i < 26;i++){
            q.offer(new int[]{i,freq[i]});
        }
        int[] pressTime = new int[26];
        for(int i = 0;i < 26;i++){
            int[] cur = q.poll();
            if(i < 9){
                pressTime[cur[0]] = 1;
            }else if(i >= 9 && i < 18){
                pressTime[cur[0]] = 2;
            }else{
                pressTime[cur[0]] = 3;
            }
        }
        int res = 0;
        for(int i = 0;i < s.length();i++){
            res += pressTime[s.charAt(i)-'a'];
        }
        return res;
    }
}
