public class Leetcode1293 {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        if (k >= m + n - 2)
            return m + n - 2;
        int[][] maxRemainK = new int[m][n];
        for (int[] row : maxRemainK)
            Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, k });
        maxRemainK[0][0] = k;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                int curK = cur[2];
                if (r == m - 1 && c == n - 1)
                    return steps;
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;
                    int nextK = curK - grid[nr][nc];
                    if (nextK >= 0 && nextK > maxRemainK[nr][nc]) {
                        maxRemainK[nr][nc] = nextK;
                        q.offer(new int[] { nr, nc, nextK });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
