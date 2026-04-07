public class Leetcode542 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    seen[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || seen[nx][ny])
                    continue;
                seen[nx][ny] = true;
                q.offer(new int[] { nx, ny });
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        return dist;
    }
}
