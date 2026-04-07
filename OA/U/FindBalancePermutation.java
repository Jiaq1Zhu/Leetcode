public class FindBalancePermutation {
    public static String countBalanceNumbers(int[] p) {
        int n = p.length;
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[p[i]] = i;
        }
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int k = 1; i <= n; k++) {
            minIndex = Math.min(minIndex, pos[k]);
            maxIndex = Math.max(maxIndex, pos[k]);
            sb.append((maxIndex - minIndex + 1) == k ? '1' : '0');
        }
        return sb.toString();
    }
}
