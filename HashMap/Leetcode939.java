import java.util.HashMap;
import java.util.HashSet;

public class Leetcode939 {
    public int minAreaRect(int[][] points){
        int res = Integer.MAX_VALUE;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] point:points){
            if(!map.containsKey(point[0])){
                map.put(point[0],new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int[] p1:points){
            for(int[] p2:points){
                // if two points are neighboor skip it
                // we want to find diagano
                if(p1[0] == p2[0] || p1[1] == p2[1])continue;
                // check if current two points can be diagnal points
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])){
                    min = Math.min(min,Math.abs(p1[0]-p2[0])* Math.abs(p1[1]-p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}
