import java.util.Stack;

public class Leetcode907 {
    public int sumSubarrayMins(int[] arr){
        int res = 0, n = arr.length, M=(int)1e9+7;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] dp = new int[n+1];
        for(int i = 0;i < n;i++){
            while(stack.peek() != -1 && arr[i] <= arr[stack.peek()]){stack.pop();}
            dp[i+1] = (dp[stack.peek()+1]+(i-stack.peek())*arr[i])%M;
            stack.push(i);
            res = (res+dp[i+1])%M;
        }
        return res;
    }
}
