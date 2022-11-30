class Leetcode79{
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(word,board,visited,0,i,j))return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(String s,char[][] board, boolean[][] visited, int index,int x, int y){
        if(index == s.length())return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != s.charAt(index))return false;
        visited[x][y] = true;
        boolean res = dfs(s,board,visited,index+1,x+1,y)||dfs(s,board,visited,index+1,x-1,y)||dfs(s,board,visited,index+1,x,y+1)||dfs(s,board,visited,index+1,x,y-1);
        visited[x][y] = false;
        return res;
    }
}