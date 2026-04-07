public class MinOperationToZero {
    public static int minOperations(int n) {
        int operations = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                n += 1;
                operations++;
            } else if ((n & 1) == 1) {
                n -= 1;
                operations++;
            } else {
                n >>= 1;
            }
        }
        return operations;
    }
}
