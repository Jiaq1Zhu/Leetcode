public class Leetcode207 {
    // leetcode 207 Courseschedule
    /**
     * In this problem, we are goning to find that if we had a circle in the graph
     * we have a visited array, we mark -1 as in path, 1 is complete
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i <numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] courses:prerequisites){
            int course = courses[0];
            int req = courses[1];
            graph.get(course).add(req);
        }
        int[] visited = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            if(!dfs2(graph,visited,i))return false;
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph,int[]visited,int curr){
        if(visited[curr] == 1)return true;
        if(visited[curr] == -1)return false;
        visited[curr] = -1;
        for(int next:graph.get(curr)){
            if(!dfs(graph,visited,next))return false;
        }
        visited[curr] = 1;
        return true;
    }
}
