public class Leetcode1135 {
    class UnionFind{
        public int count;
        int[] parent;
        public UnionFind(int x){
            this.count = x;
            this.parent = IntStream.range(0, x).toArray();
        }
        public int find(int x){
            if(parent[x] != x)return find(parent[x]);
            return x;
        }
        public void union(int x,int y){
            int fx = find(x), fy = find(y);
            if(fx != fy){
                parent[fx] = fy;
                this.count--;
            }
        }
        public boolean isConnected(int x,int y){
            return find(x) == find(y);
        }
    }
    public int minConnected(int n, int[][] connections){
        if(n == 0 || connections == null || connections.length == 0 || connections[0].length == 0)return -1;
        UnionFind uf = new UnionFind(n);
        Arrays.sort(connections,(a,b)->a[2]-b[2]);
        int res = 0;
        for(int[] c :connections){
            int x = c[0], y = c[1], cost = c[2];
            if(!uf.isConnected(x-1, y-1)){
                uf.union(x-1, y-1);
                res+= cost;
            }
            if(uf.count == 1)break;
        }
        return uf.count == 1?res:-1;
    }
}
