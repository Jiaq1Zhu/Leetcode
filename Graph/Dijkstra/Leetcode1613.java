public class Leetcode1613 {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        // 存储相邻节点
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                // out of bound;
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }
    class State {
        // a position in the matrix
        int x, y;
        // effort we need from (0,0) to current point
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // dp table 
        int[][] effortTo = new int[m][n];
        // init
        for(int i = 0;i < m;i++){
            Arrays.fill(effortTo[i],Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>((a,b)->a.effortFromStart-b.effortFromStart);
        pq.offer(new State(0,0,0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;
            // if we reach the end point
            if(curX == m - 1 && curY == n-1){
                return curEffortFromStart;
            }
            for(int[] neighbor:adj(heights,curX,curY)){
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                // check if we need more effort in this action
                int effortToNextNode = Math.max(effortTo[curX][curY],Math.abs(heights[curX][curY]-heights[nextX][nextY]));
                if(effortTo[nextX][nextY] > effortToNextNode){
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX,nextY,effortToNextNode));
                }
            }
            
        }
        return -1;
    }
}
