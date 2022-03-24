public class Leetcode797 {
    // Leetcode 797
     // This is just simple dfs
     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,0,graph);
        return res;
        
    }
    private void dfs(List<List<Integer>> res, List<Integer> path, int curr,int[][]graph){
        path.add(curr);
        if(curr == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int next:graph[curr]){
            dfs(res,path,next,graph);
            path.remove(path.size()-1);
        }
    }

}
