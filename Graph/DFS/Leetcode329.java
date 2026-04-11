public class Leetcode329 {
    /*
     * This is a hard question, the idea is to use DFS to find the longest
     * increasing path in the matrix. We can use a memoization array to store the
     * longest increasing path starting from each cell. We can also use a visited
     * array to avoid cycles in the DFS. The time complexity of this solution is
     * O(m*n) where m and n are the dimensions of the matrix.
     */
    int[][] memo;
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        if (m == 0)
            return 0;
        memo = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, visited));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (memo[i][j] > 0)
            return memo[i][j];
        int res = 0;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && matrix[i][j] < matrix[row][col]) {
                res = Math.max(res, dfs(matrix, row, col, visited));
            }
        }
        visited[i][j] = false;
        memo[i][j] = res + 1;
        return memo[i][j];
    }
}
