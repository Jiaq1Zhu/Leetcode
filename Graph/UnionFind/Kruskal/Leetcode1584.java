public class Leetcode1584 {
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            while(parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)return;
            parent[rootX] = parent[rootY];
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
        
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for(int i = 0;i < points.length;i++){
            for(int j = 0;j < points.length;j++){
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i,j,Math.abs(xi-xj)+Math.abs(yi-yj)});
            }
        }
        Collections.sort(edges,(a,b)->a[2]-b[2]);
        int res = 0;
        UnionFind uf = new UnionFind(points.length);
        for(int[] edge:edges){
            int x = edge[0];
            int y = edge[1];
            int weight = edge[2];
            if(uf.isConnected(x,y))continue;
            uf.union(x,y);
            res += weight;
        }
        return res;
    }
}
