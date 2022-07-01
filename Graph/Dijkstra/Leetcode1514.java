public class Leetcode1514 {
    class State{
        int id;
        double probFromStart;
        public State(int id, double probFromStart){
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }
    
    private double dijkstra(int start, int end,List<double[]>[] graph){
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo,-1);
        probTo[start] = 1;
        Queue<State> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b.probFromStart,a.probFromStart);
        });
        pq.offer(new State(start,1));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            double curProbFromStart = curState.probFromStart;
            if(curId == end)return curProbFromStart;
            
            if(curProbFromStart < probTo[curId])continue;
            
            for(double[] neighbor:graph[curId]){
                int nextNodeId = (int)neighbor[0];
                double probToNext = probTo[curId]*neighbor[1];
                if(probTo[nextNodeId] < probToNext){
                    probTo[nextNodeId] = probToNext;
                    pq.offer(new State(nextNodeId,probToNext));
                }
            }
        }
        // if we reach this statement it means end cannot be reached.
        return 0.0;
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        List<double[]>[] graph = new LinkedList[n];
        for(int i = 0;i < n;i++){
            graph[i] = new LinkedList<>();
        }
        for(int i = 0;i < edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{to,weight});
            graph[to].add(new double[]{from,weight});
        }
        return dijkstra(start,end,graph);
    }
}
