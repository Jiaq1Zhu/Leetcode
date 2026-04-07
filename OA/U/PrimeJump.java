public class PrimeJump {
    /**
     * 每一个cells[i]表示第i个格子的分数，玩家从第0格开始，每次可以跳1格或者p格
     * p需要是一个质数并且以3结尾，求玩家能得到的最大分数
     */

    public static int maxGameScore(List<Integer> cells) {
        /*
         * 首先需要找到所有以3结尾的质数，假设最大的格子数为n，那么我们需要找到小于等于n的所有以3结尾的质数。
         * 然后我们可以使用动态规划来解决这个问题。我们定义一个数组dp，其中dp[i]表示玩家在第i个格子上能得到的最大分数。
         * 初始化dp[0] =
         * cells[0]，因为玩家从第0格开始。对于每个格子i，我们可以跳1格或者跳p格（p是一个以3结尾的质数）。因此，我们需要遍历所有的以3结尾的质数p，
         * 并更新dp[i]的值：
         * dp[i] = max(dp
         */

        boolean[] isPrime = new boolean[cells.size() + 1];
        Arrays.fill(isPrime, true);
        /*
         * 先用埃氏筛查法 找到所有质数
         */
        if (cells.size() >= 1)
            isPrime[0] = false;
        if (cells.size() >= 2)
            isPrime[1] = false;
        for (int i = 2; i * i <= cells.size(); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= cells.size(); j += i) {
                    isPrime[j] = false;
                }
            }
        }
        /* 找到所有以3结尾的质数 */
        List<Integer> validJumps = new ArrayList<>();
        for (int i = 2; i <= cells.size(); i++) {
            if (isPrime[i] && i % 10 == 3) {
                validJumps.add(i);
            }
        }

        int[] dp = new int[cells.size()];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = cells.get(0);
        for (int i = 1; i < cells.size(); i++) {
            if (dp[i] == Integer.MIN_VALUE)
                continue; // 如果这个格子不可达，跳过
            // 跳1格
            if (i + 1 < cells.size()) {
                dp[i + 1] = Math.max(dp[i + 1], dp[i] + cells.get(i + 1));
            }
            // 跳p格
            for (int jump : validJumps) {
                if (i + jump < cells.size()) {
                    dp[i + jump] = Math.max(dp[i + jump], dp[i] + cells.get(i + jump));
                }
            }
        }

        return dp[cells.size() - 1];
    }
}
