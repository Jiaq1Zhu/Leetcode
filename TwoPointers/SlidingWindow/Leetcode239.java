public class Leetcode239 {
    // we have a monotonic queue, the max is always on the first position of the queue.
    class MonotonicQueue{
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n){
            while(!q.isEmpty() && q.getLast() < n)q.pollLast();
            q.addLast(n);
        }
        public int max(){
            return q.getFirst();
        }
        public void pop(int n){
            if(n == q.getFirst())q.pollFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue q = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        // we use sliding window here.
        for(int i = 0;i <nums.length;i++){
            if(i < k-1){
                q.push(nums[i]);
            }else{
                q.push(nums[i]);
                list.add(q.max());
                q.pop(nums[i-k+1]);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
