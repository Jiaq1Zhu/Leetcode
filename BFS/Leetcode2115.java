import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Leetcode2115 {
    public List<String> getOrder(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supply = new HashSet<>();
        for (String s : supplies) {
            supply.add(s);
        }
        int[] inDegree = new int[recipes.length];
        Map<String, List<Integer>> nexts = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            List<String> ingres = ingredients.get(i);
            for (String ingre : ingres) {
                if (!supply.contains(ingre)) {
                    inDegree[i]++;
                    nexts.computeIfAbsent(ingre, v -> new ArrayList()).add(i);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(recipes[cur]);
            if (nexts.containsKey(recipes[cur])) {
                List<Integer> next = nexts.get(recipes[cur]);
                for (int n : next) {
                    if (--inDegree[n] == 0) {
                        q.offer(n);
                    }
                }
            }
        }
        return res;
    }
}
