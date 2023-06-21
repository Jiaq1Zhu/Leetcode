import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DistinctTraversal {
    public static int[] traversal(int n, int[] from, int[] to){
        Map<Integer,PriorityQueue<Integer>> graph = new HashMap<>();
        for(int i = 0;i < from.length;i++){
            graph.putIfAbsent(from[i], new PriorityQueue<>((a,b)->(b-a)));
            graph.putIfAbsent(to[i], new PriorityQueue<>((a,b)->(b-a)));
            graph.get(from[i]).offer(to[i]);
            graph.get(to[i]).offer(from[i]);
        }
        List<Integer> curPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(graph,curPath,visited,n,n);
        int[] res = new int[n];
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(int i = 0;i < curPath.size();i++){
            if(set.contains(curPath.get(i)))continue;
            else res[index++] = curPath.get(i);
            set.add(curPath.get(i));
        }

        return res;
    }

    public static void dfs(Map<Integer,PriorityQueue<Integer>> graph, List<Integer> curPath, Set<Integer> visited, int curNode, int nodeNum){
        // start to travel, from the largest
        PriorityQueue<Integer> nexts = graph.get(curNode);
        // add self to the path
        curPath.add(curNode);
        // ad self to visited
        visited.add(curNode);
         // if all has been visited;
        // if(visited.size() == nodeNum)return;
        while(!nexts.isEmpty()){
            // travel the largest with number
            int next = nexts.peek();
            if(visited.contains(next)){
                // already visited,skip
                nexts.poll();
                continue;
            }else{
                // not visited, start from next
                dfs(graph,curPath,visited,next,nodeNum);
                // go back to current node to visited next node;
                // if all node has been visited, return
                if(visited.size() == nodeNum)return;
                curPath.add(curNode);
            }
        }

    }

    public static void main(String[] args) {
        int num = 5;
        int[] from = new int[]{4,5,1,4,3};
        int[] to = new int[]{5,1,4,3,2};
        int[] res = traversal(num, from, to);

        for(int i :res){
            System.out.println(i);
        }
    }
}
