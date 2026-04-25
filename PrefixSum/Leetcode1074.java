public class Leetcode1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int count = 0;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int curSum = 0;
                for (int row = 0; row < m; row++) {
                    curSum += matrix[row][right] - (left > 0 ? matrix[row][left - 1] : 0);
                    count += map.getOrDefault(curSum - target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return count;
    }
}
