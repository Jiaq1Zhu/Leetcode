import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j], v -> new ArrayList<>()).add(i);
            }
        }
        Set<Integer> buses = new HashSet<>(), stops = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == target)
                    return res;
                if (!map.containsKey(cur))
                    return -1;
                for (int route : map.get(cur)) {
                    if (buses.contains(route))
                        continue;
                    buses.add(route);
                    for (int next : routes[route]) {
                        if (stops.contains(next))
                            continue;
                        stops.add(next);
                        q.offer(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
