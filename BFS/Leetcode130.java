public class Leetcode130 {
    /**
     * In this problem, we start from every cell at border to and switch it to another letter. Then we change every cell to X.
     * @param board
     */
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)return ;
        int m = board.length, n = board[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j <n;j++){
                if(i == 0 || j == 0|| i == m-1||j == n-1){
                    bfs(board,i,j);
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j <n;j++){
                board[i][j] = (board[i][j] == 'V')?'O':'X';
            }
        }
    }
    
    public void bfs(char[][] board,int i, int j){
        if(board[i][j] != 'O')return;
        int M = board.length, N = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int[] coord = q.poll();
            int x = coord[0], y = coord[1];
            if(x < 0 || x >= M || y < 0 || y >= N)continue;
            if(board[x][y] != 'O')continue;
            board[x][y] = 'V';
            q.offer(new int[]{x+1,y});
            q.offer(new int[]{x-1,y});
            q.offer(new int[]{x,y+1});
            q.offer(new int[]{x,y-1});
        }
    }
}
