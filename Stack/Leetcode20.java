public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(isLeft(c))stack.push(c);
            else{
                if(!stack.isEmpty()&& isClosed(stack.peek(),c)){
                stack.pop();
                }
                else return false;
            }
        }
        return stack.size() == 0;
    }
    public boolean isLeft(char c){
        if(c == '(' || c == '{' || c == '[')return true;
        return false;
    }
    
    public boolean isClosed(char left, char right){
        if(left == '{' && right == '}')return true;
        if(left == '[' && right == ']')return true;
        if(left == '(' && right == ')')return true;
        return false;
    }
}
