public class PrefixScore {
    public static int[] getPrefixScore(int[] A){
        int k = A.length;
        int[] res = new int[k];
        int curMax = 0, prev = 0;
        for(int i = 0;i < k;i++){
            curMax += A[i];
            res[i] = curMax + prev;
            prev = res[i];
        }
        curMax = 0;
        for(int i = 0;i < k;i++){
            curMax = Math.max(curMax,A[i]);
            res[i] += curMax * (i+1);
            res[i] %= (int)1e9+7;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int[] res = getPrefixScore(arr);
        for(int i = 0;i < res.length;i++){
            System.out.println(res[i]);
        }
    }
}
