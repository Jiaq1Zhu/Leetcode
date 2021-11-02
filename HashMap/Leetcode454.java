package HashMap;

import java.util.Map;

public class Leetcode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                map.put(nums1[i]+nums2[j], map.getOrDefault(nums1[i]+nums2[j], 0)+1);
            }
        }
        for(int i = 0;i < nums3.length;i++){
            for(int j = 0;j < nums4.length;j++){
                int target = -1 * (nums3[i] + nums4[j]);
                res +=  map.getOrDefault(target, 0);
            }
        }
        return res;
    }
}
