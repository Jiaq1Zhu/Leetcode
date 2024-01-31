import java.util.List;
import java.util.Map;

public class Leetcode465 {
    int res = Integer.MAX_VALUE;

    public int minTransfer(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : map.values()) {
            if (i != 0)
                list.add(i);
        }
        dfs(list, 0, 0);
        return res;
    }

    private void dfs(List<Integer> list, int start, int count) {
        int n = list.size();
        while (start < n && list.get(start) == 0)
            start++;
        if (start == n) {
            res = Math.min(res, count);
            return;
        }
        for (int i = start + 1; i < n; i++) {
            if ((list.get(start) > 0 && list.get(i) < 0) || (list.get(start) < 0 && list.get(i) > 0)) {
                int ori = list.get(i);
                list.set(i, ori + list.get(start));
                dfs(list, start + 1, count + 1);
                list.set(i, ori);
            }
        }
    }
}
