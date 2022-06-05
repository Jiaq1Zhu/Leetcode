package BFS;

public class Leetcode994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1)fresh++;
            }
        }
        int res = -1;
        if(fresh == 0)return 0;
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            while(size-- > 0){
                int[] cur = q.poll();
                for(int[] dir:dirs){
                    int i = cur[0]+dir[0];
                    int j = cur[1] + dir[1];
                    if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1){
                        grid[i][j] = 2;
                        fresh--;
                        q.offer(new int[]{i,j});
                    }
                }
            }
        }
        if(fresh != 0)return -1;
        return res;
    }
}
