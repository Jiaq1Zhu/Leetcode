package Heap;

public class Leetcode973 {
    class Distance{
        Double distance;
        int index;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> maxHeap = new PriorityQueue<>((a,b)->a.distance.compareTo(b.distance));
        for(int i = 0;i < points.length;i++){
            Distance d = new Distance();
            d.index = i;
            d.distance = Math.sqrt(Math.pow(points[i][0],2)+ Math.pow(points[i][1],2));
            maxHeap.offer(d);
        }
        int[][] res = new int[k][2];
        for(int i = 0;i < k;i++){
            res[i] = points[maxHeap.poll().index];
        }
        return res;
    }
}
