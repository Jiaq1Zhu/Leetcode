import java.util.Stack;
/**
 * I think this problem is better categorized as mono stack instead of DP since dp is not necessary.
 * However, dp in this solution is very important
 * 
 * dp[i] in this problem stands for the  min sum of subarrays that end with arr[i-1];
 * We will have a monotonous stack to store the index.
 * It is monotonous stack because we want to make it's peek is the index of the first value that is on the left and smaller than current value;
 * No we can get the dp[i] by calculate two parts.
 * 1: dp[stack.peek()+1] end with previsou smallest value
 * 2: (i-stack.peek()) * arr[i]; end with current value;
 *  we add them up, we get what we want.
 * For example:
 *  [3,1,2,4] => dp[0,3,2,4,8] 
 *  for subarray ended with 3 we got only [3]
 * for subarray end with 1 we got [3,1] and [1]
 * for 2 we got [2],[1,2][3,1,2];
 * for 4 we go [3,1,2,4],[1,2,4],[2,4],[4]
 */
public class Leetcode907 {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length, M = (int)1e9+7;
        int[] dp = new int[n+1];
        stack.push(-1);
        int res = 0;
        for(int i = 0;i < n;i++){
            while(stack.peek() != -1 && arr[stack.peek()] >= arr[i])stack.pop();
            int idx = stack.peek();
            dp[i+1] = (dp[idx+1] + (i-idx)*arr[i])%M;
            stack.push(i);
            res =(res + dp[i+1])%M;
        }
        return res;
    }
}
