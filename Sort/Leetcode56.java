class Leetcode56{
    public int[][] mergeInterval(int[][] intervals){
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int[] last = null;
        for(int[] interval:intervals){
            if(last == null ||last[1] < interval[0]){
                list.add(interval);
                last = interval;
            }else{
                last[1] = Math.max(last[1],interval[1]);
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}