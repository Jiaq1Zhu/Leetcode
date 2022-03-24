public class Leetcode261 {
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
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)return false;
            parent[rootX] = parent[rootY];
            return true;
        }
        public int getCount(){
            int count = 0;
            for(int i = 0;i < parent.length;i++){
                if(parent[i] == i)count++;
            }
            return count;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            if(!uf.union(edge[0],edge[1]))return false;
        }
        if(uf.getCount() != 1)return false;
        return true;
    }
}
