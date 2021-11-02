import java.util.Map;

class Leetcode532{
    public int findPairs(int[] nums,int k){
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int x = entry.getKey();
            int val = entry.getValue();
            if(k > 0 && map.containsKey(x+k)){
                result++;
            }
            if(k == 0 && val>1){
                result++;
            }
        }
        return result;
    }
}