public class Leetcode990 {
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
        public boolean isConnect(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)return true;
            return false;
        }
        
    }
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String eq:equations){
            if(eq.charAt(1) == '='){
                System.out.println(eq);
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x-'a',y-'a');
            }
        }
        for(String eq:equations){
            if(eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.isConnect(x-'a',y-'a'))return false;
            }
        }
        return true;
    }
}
