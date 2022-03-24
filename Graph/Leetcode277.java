public class Leetcode277 {
    // dummy api 
    boolean knows(int x, int y){return true;}

    // in this problem, we elimiate the candidate based on several conditions.
    public int findCelebrity(int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            q.offer(i);
        }
        while(q.size()>=2){
            int cand = q.poll();
            int other = q.poll();
            // if this candidate knows somebody or somebody did not know the candiate, the candidate is out.
            if(knows(cand,other) || !knows(other,cand)){
                q.offer(other);
            }else{
                // we keep that candidate
                q.offer(cand);
            }
        }
        // verify the last candidate
        int cand = q.poll();
        for(int i = 0;i < n;i++){
            if(i == cand)continue;
            if(!knows(i,cand)||knows(cand,i))return -1;
        }
        return cand;
    }
    
}


