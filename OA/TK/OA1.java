import java.util.Arrays;
public class OA1{
    public static int getSum(int[] nums){
        Arrays.sort(nums);
        int res = 0;
        int needs = 0;
        for(int n:nums){
            res += Math.max(n,needs);
            needs = Math.max(needs,n)+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{3,2,1,2,7,2};
        int res = getSum(testArray);
        System.out.println(res);
    }
}