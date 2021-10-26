class Leetcod370{
    public int[] getModifiedArray(int length,int[][] updates){
        int[] prefixSum = new int[length];
        for(int[] update:updates){
            prefixSum[update[0]] += update[2];
            if(update[1] + 1 < length){
                prefixSum[update[1]+1]-=update[2];
            }
        }
        for(int i = 1;i < length;i++){
            prefixSum[i] += prefixSum[i-1];
        }
        return prefixSum;
    }
}