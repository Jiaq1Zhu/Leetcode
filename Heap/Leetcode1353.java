package Heap;

public class Leetcode1353 {
    public int maxEvents(int[][] events) {
        // we sort event based on their start time
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        // we use a pq to store the enddate of everyevent
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int res = 0, day = 0, n = events.length, i = 0;
        while(i < n || !q.isEmpty()){
            if(q.isEmpty()){
                // nothing in the q, we get current day
                day = events[i][0];
            }
            while(i < n && day == events[i][0]){
                //enque every event that starts today;
                q.offer(events[i][1]);
                i++;
            }
            //attend an event, move to next day
            q.poll();
            res++;
            day++;
            
            //remove everyevent that has already ended in the queue
            while(!q.isEmpty() && q.peek() < day){
                q.poll();
            }
        }
        return res;
    }
    
}
