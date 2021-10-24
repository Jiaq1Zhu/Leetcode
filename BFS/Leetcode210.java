package BFS;

import java.util.Queue;

public class Leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        //use indegree to mark course without andy prerequisites
        // then we use bfs to traverse the graph until every reachable course has been taken.
        int len = prerequisites.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] i : prerequisites){
            int course = i[0];
            int preReq = i[1];
            graph.get(preReq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int j = 0;
        while(!q.isEmpty()){
            int c = q.poll();
            res[j++] = c;
            for(int i:graph.get(c)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    q.offer(i);
                }
            }
        }
        if(j == numCourses)return res;
        return new int[0];
    }
}
