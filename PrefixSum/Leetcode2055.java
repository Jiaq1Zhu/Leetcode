public class Leetcode2055 {
    public int[] platesBetweenCandles(String s, int[][] queries){
        int n = s.length();
        // array to store closest candle index before current position
        int[] before = new int[n];
        // array to store closest candle index after current position
        int[] after = new int[n];
        // pos init to be -1 since there is no candle before first position
        int pos = -1;
        // scan from left to right
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == '|'){
                pos = i;
            }
            before[i] = pos;
        }

        pos = -1;
        for(int i = n-1; i >= 0;i--){
            if(s.charAt(i) == '|'){
                pos = i;
            }
            after[i] = pos;
        }
        int[] prefixSum = new int[n];
        for(int i = 0;i < n;i++){
            // calculate plate number prefix sum
            if(s.charAt(i) == '|'){
                prefixSum[i] = i-1>=0?prefixSum[i-1]:0;
            }else{
                prefixSum[i] = i-1>=0?(prefixSum[i-1]+1):1;
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0;i < queries.length;i++){
            int[] q = queries[i];
            // find the left most candle in range
            int left = after[q[0]];
            // find the right most candle in range
            int right = before[q[1]];
            if(left != -1 && right != -1 && left < right){
                res[i] = prefixSum[right] - prefixSum[left];
            }
        }
        return res;
    }
}
