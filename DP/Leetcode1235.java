public class Leetcode1235 {

    // DP + Binary Search
    // dp[i] means the maximum profit we can get by scheduling jobs[0...i-1]
    // dp[i] = max(dp[i-1], dp[previous] + profit[i-1]) where previous is the index
    // of the last job that ends before the start time of the current job, we can
    // find
    // previous by binary search since the jobs are sorted by end time.
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int previous = bs(jobs, jobs[i - 1][0]);
            dp[i] = Math.max(dp[previous] + jobs[i - 1][2], dp[i - 1]);
        }
        return dp[n];

    }

    public int bs(int[][] jobs, int startTime) {
        int left = 0, right = jobs.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (jobs[mid][1] <= startTime) {
                res = mid + 1;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }
}
