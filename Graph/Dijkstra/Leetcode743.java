import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode743 {
    class State{
        // id of current node
        int id;
        // distance from start to current node
        int distance;
        public State(int id, int distance){
            this.id = id;
            this.distance = distance;
        }
    }    

    private int[] dijkstra(int start, List<int[]>[] graph){
        // dp table for distance from start to each node
        int[] distTo = new int[graph.length];   

        // initialize dp table
        Arrays.fill(distTo,Integer.MAX_VALUE);
        distTo[start] = 0;
        Queue<State> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new State(start,0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curNodeId = curState.id;
            int curDistance = curState.distance;
            // current dp table has a better value
            if(curDistance > distTo[curNodeId])continue;
            for(int[] neighbor:graph[curNodeId]){
                int nextNodeId = neighbor[0];
                int distToNext = distTo[curNodeId] + neighbor[1];
                if(distTo[nextNodeId] > distToNext){
                    distTo[nextNodeId] = distToNext;
                    pq.offer(new State(nextNodeId,distToNext));
                }
            }
        }
        return distTo;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
         for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // construct the graph
        for(int[] edge :times){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        
        int[] distTo = dijkstra(k,graph);
        int res = 0;
        for(int i = 1;i < distTo.length;i++){
            if(distTo[i] == Integer.MAX_VALUE)return -1;
            res = Math.max(res,distTo[i]);
        }
        return res;
    }
}
