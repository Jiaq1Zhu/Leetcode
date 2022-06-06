public class Leetcode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null ||board.length == 0||board[0].length == 0)return board;
        int m = board.length, n = board[0].length;
        int mineCount = 0;
        int x = click[0], y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }else{
            List<int[]> neighboors = new ArrayList<>();
            for(int i = -1;i < 2;i++){
                for(int j = -1;j < 2;j++){
                    int row = x + i, col = y+j;
                    if(row < 0 || row >=m || col < 0 || col >= n)continue;
                    if(board[row][col] == 'M')mineCount++;
                    else if(mineCount == 0 && board[row][col] == 'E'){
                        neighboors.add(new int[]{row,col});
                    }
                }
            }
            if(mineCount > 0){
            board[x][y] = (char)(mineCount+'0');
        }
        else {
            for(int[] next:neighboors){
                board[next[0]][next[1]] = 'B';
                updateBoard(board,next);
            }
        }
        }
        
        return board;
    }
    
}
