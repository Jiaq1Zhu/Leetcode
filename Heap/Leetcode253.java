class Leetcode253{
    public int meetingRooms(int[][] intervals){
        // we need to find how many meeting rooms we need
        // First we sort the intervals based on start times
        // we create a min heap base intervals finished time so the interval with earliest finished time will be on the top of the heap.
        //Compare and check if we need a new room.
        if(intervals == null || intervals.length == 1)return 1;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.offer(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            int[] early = minHeap.poll();
            int[] curr = intervals[i];
            if(early[1] <= curr[0]){
                early[1] = curr[1];
            }else{
                minHeap.offer(curr);
            }
            minHeap.offer(early);
        }
        return minHeap.size();
    }
}