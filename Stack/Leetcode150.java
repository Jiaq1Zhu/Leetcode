public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)return 0;
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                stack.push(Integer.parseInt(s));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(s.equals("+"))stack.push(num1+num2);
                if(s.equals("-"))stack.push(num2-num1);
                if(s.equals("*"))stack.push(num2*num1);
                if(s.equals("/"))stack.push(num2/num1);
            }
        }
        return stack.peek();
    }
}
