class Leetcode323 {
    //this is basiclly an union find template.
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
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
        public boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB)return false;
            parent[rootA] = rootB;
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
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.getCount();
    }
}