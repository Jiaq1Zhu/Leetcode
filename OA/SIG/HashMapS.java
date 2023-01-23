import java.util.HashMap;

public class HashMapS {
    long solution(String[] queryType, int[][] query) {
        int curKeyInc = 0;
        int curValInc = 0;
        HashMap<Integer, Integer> mp = new HashMaps<>();
        long ans = 0;
        for (int i = 0; i < queryType.length; i++) {
          if (queryType[i].equals("insert")) {
            mp.put(query[i][0] - curKeyInc, query[i][1] - curValInc);
          } else if (queryType[i].equals("addToValue")) {
            curValInc += query[i][0];
          } else if (queryType[i].equals("addToKey")) {
            curKeyInc += query[i][0];
          } else {
            ans += mp.getOrDefault(query[i][0] - curkeyInc, -1 * curValInc) + curValInc;
          }
          return ans;
        }
      }
}
