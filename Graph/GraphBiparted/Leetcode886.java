public class Leetcode886 {
    // Leetcode 886
     // It is same solution as 785, instead we need to kinda build the graph by ourselves.
     public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colored = new int[n+1];
        if(dislikes == null || dislikes.length == 0)return true;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 1;i <= n;i++){
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for(int[] dislike: dislikes){
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        for(int i = 1;i <= n;i++){
            if(colored[i] != 0)continue;
            colored[i] = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next:graph.get(curr)){
                    if(colored[curr] == colored[next])return false;
                    if(colored[next] == 0){
                        colored[next] = -1 * colored[curr];
                        q.offer(next);
                    }
                }
            }
        }
        return true;
    }
}
