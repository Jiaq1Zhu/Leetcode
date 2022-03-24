package UnionFind;

public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[]parent = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(isConnected[i][j] == 1){
                    union(parent,i,j);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i < n;i++){
            if(parent[i] == i)ans++;
        }
        return ans;
        
    }
    public int find(int[] parent,int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    private void union(int[] parent,int x, int y){
        parent[find(parent,y)] = parent[find(parent,x)];
    }
}
