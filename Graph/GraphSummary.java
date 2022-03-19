public class GraphSummary {
    /**
     * In this file I will go through some algorithm to traverse, detect circle in Undirected graph
     */

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
    private boolean dfs2(List<List<Integer>> graph,int[]visited,int curr){
        if(visited[curr] == 1)return true;
        if(visited[curr] == -1)return false;
        visited[curr] = -1;
        for(int next:graph.get(curr)){
            if(!dfs2(graph,visited,next))return false;
        }
        visited[curr] = 1;
        return true;
    }

    //Leetcode 210
    /**
     * This problem not only ask you to detect if it can be finish, it also ask you to return a possible sequence of taking this course.
     * This problem is asking you to return a result of topological sort.
     * We can do this in BFS way. I think dfs is a little bit counter intuitive.
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i = 0;i <numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] courses:prerequisites){
            int course = courses[0];
            int req = courses[1];
            graph.get(req).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            //start with courses that do not need requirement.
            if(inDegree[i] == 0)q.offer(i);
        }
        int[] res = new int[numCourses];
        int j = 0;
        while(!q.isEmpty()){
            int c = q.poll();
            for(int i:graph.get(c)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    //if all prereq are completed
                    q.offer(i);
                }
            }
            res[j++] = c;
        }
        //check if we take all the courses
        if(j == numCourses)return res;
        //unable to do that.
        else return new int[]{};
    }


}
