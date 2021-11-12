import java.util.PriorityQueue;

public class Leetcode1167 {
    public int connectSticks(int[] sticks){
        if(sticks.length < 2)return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s:sticks){
            minHeap.offer(s);
        }
        int res = 0;
        while(!minHeap.isEmpty()){
            int sum = minHeap.poll();
            if(!minHeap.isEmpty()){
                sum += minHeap.poll();
                minHeap.offer(sum);
                res += sum;
            }
        }
        return res;
    }
}
