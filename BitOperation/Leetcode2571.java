public class Leetcode2571 {

    public int minOperations(int n) {
        int operation = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                n += 1;
                operation++;
            } else if ((n & 1) == 1) {
                n -= 1;
                operation++;
            } else {
                n >>= 1;
            }
        }
        return operation;
    }
}
