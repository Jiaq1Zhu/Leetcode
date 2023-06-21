public class SubGrid {
    static int[][] prefix;

    public static int getSum(int row, int col){
        if(row < 0 || col < 0)return 0;
        return prefix[row][col];
    }
    public static int sumRegion(int row1, int col1, int row2,int col2){
        return getSum(row2,col2) - getSum(row1-1,col2) - getSum(row2,col1-1) + getSum(row1-1,col1-1);

    }
    public static int largestSubGrid(int[][] grid, int k){
        int n = grid.length;
        prefix = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                prefix[i][j] = getSum(i-1, j) + getSum(i, j-1)+ grid[i][j] - getSum(i-1, j-1);
            }
        }
        int left = 0,right = n, res = 0;
        while(left <= right){
            int mid = (right-left)/2 + left;
            // System.out.printf("The mid is %d\n",mid);
            if(mid == 0)return 0;
            boolean stopflag = false;
            for(int i = mid-1;i < n;i++){
                for(int j = mid-1;j < n;j++){
                    int subSum = sumRegion(i-mid+1, j-mid+1, i, j);
                    // System.out.printf("The subRegion is %d\n",subSum);
                    if(subSum > k)stopflag = true;
                }
            }
            if(stopflag)right = mid-1;
            else{
                res = mid;
                left = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,2,2},{3,3,3},{4,4,4}};
        int res0 = largestSubGrid(grid, 2);
        int res1 = largestSubGrid(grid, 4);
        int res2 = largestSubGrid(grid, 15);
        int res3 = largestSubGrid(grid, 27);
        System.out.printf("The result is %d.\n",res1);
        System.out.printf("The result is %d.\n",res0);
        System.out.println(res2);
        System.out.println(res3);
    }
}
