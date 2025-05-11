import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode2071 {
    /**
     * Yet another Binary search question on Function()
     * We will have a function call check(x) which check if we can at least complete
     * x tasks we assign
     * Then we do binary search on this X, and get the largest x.
     */
    public int maxTasks(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int left = 0, right = Math.min(n, m);
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (check(mid, workers, tasks, pills, strength))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    // in this part. we will do greedy method which is probably hard to figure out
    // by ourself.
    // that's why this is a hard question
    // But let's figure out why.
    // we will iterate top x worker with their strength(In ascending order).
    // for every worker, we will have a queue to store every tasks can be completed
    // by them(with pill)
    // if worker can handle this tasks. let this worker take the easiest tasks in
    // queue.
    // if there are still pills, let worker take pills and take hardest task in
    // queue.
    // if both condition failed. No pills means we cannot have x done.
    private boolean check(int x, int[] workers, int[] tasks, int pills, int strength) {
        int i = 0;
        Deque<Integer> q = new LinkedList<>();
        int p = pills;
        int m = workers.length;
        for (int j = m - x; j < m; j++) {
            // store every available tasks for current worker into queue.
            while (i < x && tasks[i] <= workers[j] + strength)
                q.offer(tasks[i++]);
            // queue is empty means no task available, we failed at x
            if (q.isEmpty())
                return false;
            // worker can take easist one
            if (q.peekFirst() <= workers[j])
                q.pollFirst();
            // worker cannot take easist one and we have no more pills
            else if (p == 0)
                return false;
            // take pill and took hard work;
            else {
                p--;
                q.pollLast();
            }
        }
        // we can hanlde x
        return true;
    }
}