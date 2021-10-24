package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode323 {
    /*This quesiont also has a union find implementation, time complexity is better than this dfs implementation*/
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        //Create a graph here
        for(int[] edge:edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        // dfs on every node
        for(int []edge:edges){
            int start = edge[0];
            if(visited[start])continue;
            visited[start] = true;
            dfs(visited,graph,start);
            res++;
        }
        // check if there are some other node that can not be reached by other nodes
        for(int i = 0;i < n;i++){
            if(visited[i] == false)res++;
        }
        return res;
    }

    private void dfs(boolean[] visited, Map<Integer,List<Integer>> graph, int start){
        for(int next:graph.get(start)){
            if(visited[next])continue;
            visited[next] = true;
            dfs(visited,graph,next);
        }
    }

}
