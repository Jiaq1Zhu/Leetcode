class GraphBipartedSummary {

    // Leetcode 785
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

    /**
     * Update a UnionFind version of solution
     */

     /**
      * Let first implement a standard unionFind
      */
     class UnionFind{
         public int[] parent;
         public UnionFind(int n){
             this.parent = new int[n];
         }
         public int find(int x){
             if(parent[x] != x)return find(parent[x]);
             return parent[x];
         }

         public boolean union(int x, int y){
             int rootX = find(x);
             int rootY = find(y);
             //this means two element are already in a connected graph
             if(rootX == rootY)return false;
             parent[rootX] = parent[rootY];
             return true;
         }

         public int getCount(){
             int count = 0;
             for(int i = 0;i < parent.length;i++){
                 if(parent[i] != i)count++;
             }
             return count;
         }
     }

     public boolean isBipartite2(int[][] graph){
        UnionFind uf = new UnionFind(graph.length);
        for(int i = 0;i < graph.length;i++){
             int[] edges = graph[i];
             for(int j = 0;j < edges.length;j++){
                 //if current node is already connect with one of its neighboor, this means it cannot be biparted.
                 if(uf.find(i)==uf.find(edges[j]))return false;
                 uf.union(edges[0],edges[j]);
             }
         }
         return true;
     }

     // Leetcode 886
     // It is same solution as 785, instead we need to kinda build the graph by ourselves.
     public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colored = new int[n+1];
        if(dislikes == null || dislikes.length == 0)return true;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 1;i <= n;i++){
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for(int[] dislike: dislikes){
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        for(int i = 1;i <= n;i++){
            if(colored[i] != 0)continue;
            colored[i] = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next:graph.get(curr)){
                    if(colored[curr] == colored[next])return false;
                    if(colored[next] == 0){
                        colored[next] = -1 * colored[curr];
                        q.offer(next);
                    }
                }
            }
        }
        return true;
    }
}