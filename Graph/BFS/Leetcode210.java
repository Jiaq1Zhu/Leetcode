public class Leetcode210 {
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
