public class Leetcode224 {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char op = '+';
        int num = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int j = i + 1, braces = 1;
                for (; j < n; j++) {
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
            if (c == '+' || c == '-' || i == n - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    default:
                        break;
                }
                num = 0;
                op = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
