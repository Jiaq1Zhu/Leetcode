public class MatrixTraversal {
    public static int traverse(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i <n;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1;i < m;i++){
            for(int j = 0;j <n;j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1])+matrix[i][j];
                }
                else if(j == n-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j+1],dp[i-1][j]))+matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            min = Math.min(min,dp[m-1][i]);
        }
        return 100-min;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{10,20,30,40},{60,50,20,80},{10,10,10,10},{60,50,60,50}};
        int[][] matrix2 = new int[][]{{4,6,14,21},{17,0,5,5},{4,41,22,3},{2,51,6,0}};
        int res = traverse(matrix);
        int res2 = traverse(matrix2);
        System.out.println(res);
        System.out.println(res2);
    }   
}
