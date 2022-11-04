import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OA3 {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer,List<Integer>>map = new HashMap<>();
        for(int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int[] edge:edges){
            int start = edge[0];
            if(visited[start])continue;
            visited[start] = true;
            dfs(visited,map,start);
            res++;
        }
        for(int i = 0;i < n;i++){
            if(visited[i] == false)res++;
        }
        return res;
    }
    private void dfs(boolean[] visited, Map<Integer,List<Integer>> map, int start){
        for(int next:map.get(start)){
            if(visited[next])continue;
            visited[next] = true;
            dfs(visited,map,next);
        }
    }

    class UnionFind{
        int[] parent;
        public UnionFind(int x){
            this.parent = new int[x];
            for(int i = 0;i <x;i++){
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
            parent[rootX] = rootY;
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
    public int countComponents1(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.getCount();
    }
}
