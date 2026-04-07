public class Leetcode417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dfs(heights, i, j, pVisited, heights[i][j]);
                if (i == m - 1 || j == n - 1)
                    dfs(heights, i, j, aVisited, heights[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int prev) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < prev || visited[i][j])
            return;
        visited[i][j] = true;
        int cur = heights[i][j];
        dfs(heights, i + 1, j, visited, cur);
        dfs(heights, i - 1, j, visited, cur);
        dfs(heights, i, j + 1, visited, cur);
        dfs(heights, i, j - 1, visited, cur);
    }
}
