public class OA1 {
    public static String solution(int c, int a, int b, int x, int y){
        if(a + c == x && b + c == y)return "No";
        int k = Math.max(Math.max(a, b),Math.max(x,y));
        int[][] dp = new int[k+1][k+1];
        for(int i = k;i>=0;i--){
            for(int j = k;i >= 0;j--){
                if(isPerfect(i+j)||(i == a && j ==b)){
                    continue;
                }
                else if((i-c) >-1 && (j-c)> -1 && d[i-c][j-c]==1){
                    d[i][j] = 1;
                }else if((i-j>=0 &&d[i-j][j]==1)||(j-i >= 0 && d[i][j-i]==1)){
                    d[i][j] = 1;
                }
            }
        }
        if(d[x][y]==1)return "Yes";
        return "No";
    }
    public static boolean isPerfect(int x){
        if(x >= 0){
            int sr = Math.sqrt(x);
            return sr * sr == x;
        }
        return false;
    }
}
