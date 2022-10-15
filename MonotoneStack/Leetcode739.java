public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        //monotonic stack problem, we need to find first element on the right is higher
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int curr = stack.pop();
                res[curr] = i-curr; 
            }
            stack.push(i);
        }
        return res;
    }
}
