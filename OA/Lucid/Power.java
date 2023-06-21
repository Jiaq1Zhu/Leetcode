class Power{
    public static int minCost(List<Integer>money){
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> freqTable = new HashMap<>();
        for(int i:money){
            max = Math.max(i,max);
            freqTable.put(i,freqTable.getOrDefault(i, 0)+1);
        }
        
        Map<Integer,Integer> freqTable1 = new HashMap<>(),freqTable2 = new HashMap<>();
        freqTable1.putAll(freqTable);
        freqTable2.putAll(freqTable);
        // dp1[i] cost of changing all number in money larger than i into i
        int[] dp1 = new int[max+1];
        //dp2[i] cost of changing all number less than i in money into i
        int[] dp2 = new int[max+1];
        // min(dp1[i] + dp2[i])
        int step = 0;
        for(int i = max;i>0;i--){
            dp1[i] = step;
            int curCost = freqTable1.getOrDefault(i, 0);
            step += curCost;
            int downBound = (i-1)/2 + 1;
            freqTable1.put(downBound,freqTable1.getOrDefault(downBound,0)+curCost);
        }
        step = 0;
        for(int i = 1;i<=max;i++){
            dp2[i] = step;
            int curCost = freqTable2.getOrDefault(i, 0);
            step += curCost;
            int upBound = i*2;
            freqTable2.put(upBound,freqTable2.getOrDefault(upBound,0)+curCost);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1;i <= max;i++){
            int changeUpCost = dp2[i];
            int changeDownCost = dp1[i];
            int totalCost = changeDownCost+changeUpCost;
            res = Math.min(res,totalCost);
        }
        return res;
        
    }
}