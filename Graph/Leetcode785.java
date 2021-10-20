class Leetcode785 {
    /*
    Check if the graph can be divide into two seperate graph
    Use color method to check if two node that connect with one edge has same color, if so it is not a bipartie graph.
    Use bfs function to do that.
    */
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0;i < graph.length;i++){
            if(color[i] != 0)continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1;
            while(!q.isEmpty()){
                int t = q.poll();
                for(int a:graph[t]){
                    if(color[a] == color[t])return false;
                    if(color[a] == 0){
                        color[a] = -1*color[t];
                        q.offer(a);
                    }
                }
            }
        }
        return true;
    }
}