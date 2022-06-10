class Leetcode200{
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid == null || grid.length ==0 || grid[0].length == 0)return 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j <grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    
    
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(char[][] grid,int i , int j){
        if(i < 0 ||i >= grid.length|| j < 0 || j >= grid[0].length ||  grid[i][j] == '0')return;
        grid[i][j] = '0';
        for(int[] dir:dirs){
            dfs(grid,i+dir[0],j+dir[1]);
        }
    }
}