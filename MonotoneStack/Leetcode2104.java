public class Leetcode2104 {
    public long subArrayRanges(int[] nums) {
        // very similar to 907
        // the different is to add up different between max and min within a range
        int n = nums.length;
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i <= n; i++){
            int cur = i == n?Integer.MIN_VALUE:nums[i];
            while(!stack.isEmpty() && nums[stack.peek()] > cur){
                int j = stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                res -= (long)nums[j] * (i-j) * (j-k);
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0;i <= n; i++){
            int cur = i == n?Integer.MAX_VALUE:nums[i];
            while(!stack.isEmpty() && nums[stack.peek()] < cur){
                int j = stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                res += (long)nums[j] * (i-j) * (j-k);
            }
            stack.push(i);
        }
        return res;
    }
}
