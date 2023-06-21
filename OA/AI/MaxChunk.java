public class MaxChunk {
    public int maxChunksToSort1(int[] arr){
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int prefix1 = 0;
        int prefix2 = 0;
        int res = 0;
        for(int i = 0;i < arr.length;i++){
            prefix1 += arr[i];
            prefix2 += sorted[i];
            if(prefix1 == prefix2)res++;
        }
        return res;
    }

    public int maxChunksToSort2(int[] arr){
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        
        leftMax[0] = arr[0];
        for(int i = 1;i < n;i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }

        rightMin[n-1] = arr[n-1];

        for(int i = n-2;i >= 0;i--){
            rightMin[i] = Math.min(rightMin[i+1],arr[i]);
        }
        int res = 1;
        for(int i = 0;i < n-1;i++){
            if(leftMax[i] <= rightMin[i+1])res++;
        }
        return res;

    }
}
