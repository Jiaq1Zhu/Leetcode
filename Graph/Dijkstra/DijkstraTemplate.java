import java.util.Queue;

class DijkstraTemplate{
    // we create a custome state to store necessary info
    class State{
        //the id of current node;
        int id;
        // the distance from current node to starting point;
        int dist;

        // create a constructor;
        public State(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int start,List<Integer>[] graph){
        // create dp table to store current shortest distance from start to i in dp[i]
        int[] distTo = new int[graph.length];
        // initialize the dp table
        Arrays.fill(distTo,Integer.MAX_VALUE);
        // dist to starting point is 0
        distTo[start] = 0;

        // create a heap to store the nears point to start point
        Queue<State> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new State(start,0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            int curDist = curState.dist;
            // if there is another shorter way to get to this point, we just skip it.
            if(curDist > distTo[curId])continue;
            // iterate every neighbor
            for(int[] next:graph[curId]){
                int nextId = next[0];
                // get distance from start to next by passing current node;
                int nextDist = curDist + next[1];
                // if by passing current node is better
                if(distTo[nextId] < nextDist){
                    distTo[nextId] = nextDist;
                    pq.offer(new State(nextId, nextDist));
                }
            }
        }
        return distTo;

    }
}