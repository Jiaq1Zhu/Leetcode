class UnionFind{
    int[] parent;
    int[] size;
    public UnionFind(int x){
        this.parent = new int[x];
        this.size = new int[x];
        for(int i = 0;i < x;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int getSize(int x){
        int rootX = find(x);
        return size[rootX];
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY)return false;
        int sizeX = size[rootX];
        int sizeY = size[rootY];
        if(sizeX > sizeY){
            parent[rootY] = rootX;
            size[rootX] += sizeY; 
        }else{
            parent[rootX] = rootY;
            size[rootY] += sizeX;
        }
        return true;
    }
}
public class GetGroups {
    
    public static int[] getGroups(String[] queries, int[] student1, int[] student2, int n){
        int[] res = new int[queries.length];
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i < queries.length;i++){
            int s1 = student1[i]-1;
            int s2 = student2[i]-1;
            String query = queries[i];
            if(query.equals("Total")){
                res[i] = uf.getSize(s1) + uf.getSize(s2);
            }else{
                uf.union(s1, s2);
            }
        } 
        return res;
    }

    public static void main(String[] args) {
        String[] queries = new String[]{"Friend","Friend","Total"};
        int[] student1 = new int[]{1,1,1};
        int[] student2 = new int[]{2,3,4};
        int n = 4;
        int[] res = getGroups(queries, student1, student2, n);
        for(int i:res){
            System.out.println(i);
        }
    }
}
