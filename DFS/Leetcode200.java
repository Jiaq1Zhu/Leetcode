class Leetcode200{
    public int numberOfIsland(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0)return 0;
        int res= 0;
        for(int y = 0; y < grid.length;y++){
            for(int x = 0; x < grid[0].length;x++){
                if(grid[y][x] == '1'){
                    dfs(grid,x,y);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int x, int y){
        int row = grid.length, col = grid[0].length;
        if(!inbound(row,col,x,y) || grid[y][x] == '0')return;
        else {
            grid[y][x] = '0';
            dfs(grid,x+1,y);
            dfs(grid,x-1,y);
            dfs(grid,x,y+1);
            dfs(grid,x,y-1);
        }
    }
    private boolean inbound(int row, int col, int x, int y){
        if(x < 0 || x >= col || y < 0 || y >= row)return false;
        return true;
    }
}