public class Leetcode834 {
    int[] ans;
    int[] count;
    List<List<Integer>> graph;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        this.graph = new ArrayList<>();
        this.ans = new int[n];
        this.count = new int[n];
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;

    }

    private void dfs1(int u, int p) {
        count[u] = 1;
        for (int v : graph.get(u)) {
            if (v == p)
                continue;
            dfs1(v, u);
            count[u] += count[v];
            ans[u] += ans[v] + count[v];
        }
    }

    private void dfs2(int u, int p) {
        for (int v : graph.get(u)) {
            if (v == p)
                continue;
            ans[v] = ans[u] - count[v] + (n - count[v]);
            dfs2(v, u);
        }
    }
}
