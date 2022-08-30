public class Leetcode562 {
    /**
     * For this problem, for every x,y , we search 4 directions horizontal, vertical, diagnal and anti-diagnal.
     * And find out what is the longest line consist with 1
     * @param mat
     * @return
     */
    public int longestLine(int[][] mat){
        if(mat == null || mat.length ==0 || mat[0].length == 0)return 0;
        int m = mat.length, n = mat[0].length;
        int res = 0;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,-1},{-1,1}};
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 0)continue;
                for(int k = 0; k < 4;k++){
                    int cnt = 0, x = i,y = j;
                    while(x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1){
                        x += dirs[k][0];
                        y += dirs[k][1];
                        cnt++;
                    }
                    res = Math.max(res,cnt);
                }
            }
        }
        return res;
    }
}
