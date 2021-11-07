import java.util.Map;
import java.util.Stack;

public class Leetcode907 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums2.length;i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int j =  stack.pop();
                map.put(nums2[j],nums2[i]);
            }
            stack.push(i);
        }
        for(int i = 0;i < res.length;i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
