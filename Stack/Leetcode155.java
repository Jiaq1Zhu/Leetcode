public class Leetcode155 {
    private Stack<Integer>min;
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val <= min.peek())min.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == min.peek())min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
