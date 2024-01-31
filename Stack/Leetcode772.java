public class Leetcode772 {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int j = i + 1;
                int braces = 1;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == '(')
                        braces++;
                    if (s.charAt(j) == ')')
                        braces--;
                    if (braces == 0)
                        break;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                    default:
                        break;
                }
                op = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty())
            res += stack.pop();
        return res;
    }
}
