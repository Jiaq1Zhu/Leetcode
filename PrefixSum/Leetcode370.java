class Leetcod370{
    public int[] getModifiedArray(int length,int[][] updates){
        // in this question, we try to mark the start index,and end index, we plus first to indicate a update starting position, and minus it to mark as end position.
        // in the end we add them together to get the final result;
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