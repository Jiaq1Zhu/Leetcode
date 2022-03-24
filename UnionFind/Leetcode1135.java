public class Leetcode1135 {
    class UnionFind{
        int count;
        int[] parent;
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
            }
            this.count = n;
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
            this.count--;
        }
    }
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int res = 0;
        Arrays.sort(connections,(a,b)->a[2]-b[2]);
        for(int[] connection:connections){
            uf.union(connection[0]-1,connection[1]-1);
            res += connection[2];
            if(uf.count == 1)break;
        }
        return uf.count == 1?res:-1;
    }
}
