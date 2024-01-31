public class Leetcode227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOp(c) || i == s.length() - 1) {
                if (op == '+')
                    stack.push(num);
                if (op == '-')
                    stack.push(-num);
                if (op == '*')
                    stack.push(stack.pop() * num);
                if (op == '/')
                    stack.push(stack.pop() / num);
                op = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }

    private boolean isOp(char c) {
        return (c == '+' || c == '*' || c == '/' || c == '-');
    }
}
