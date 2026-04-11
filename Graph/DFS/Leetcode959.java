public class Leetcode959 {
    public int regionsBySlashes(String[] grid) {
        /**
         * this is not a medium question, this is a hard question, the idea is to expand
         * the grid to 3 times of its size, and then use DFS to count the number of
         * regions.
         * for example, if the grid is 2x2, we will expand it to 3x3, and then we will
         * mark the cells that are occupied by the slashes, and then we will use DFS to
         * count the number of regions.
         */
        int n = grid.length;
        int[][] expanded = new int[n * 3][n * 3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);

                int r = i * 3;
                int l = j * 3;
                // fill a / shape in 3x3 grid with 1
                if (c == '/') {
                    expanded[r][l + 2] = 1;
                    expanded[r + 1][l + 1] = 1;
                    expanded[r + 2][l] = 1;
                } else if (c == '\\') {
                    // fill a \ shape in 3x3 grid with 1
                    expanded[r][l] = 1;
                    expanded[r + 1][l + 1] = 1;
                    expanded[r + 2][l + 2] = 1;
                } else {
                    continue;
                }
            }
        }
        // use dfs just like in number of islands to count the number of regions
        int count = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (expanded[i][j] == 0) {
                    dfs(expanded, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0)
            return;
        grid[x][y] = 1;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
