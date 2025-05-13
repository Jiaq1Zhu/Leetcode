import java.util.Map;
import java.util.TreeMap;

public class Leetcode352 {
    /**
     * This is leveraging binary search but we don't need to write our binary search
     * ourselves.
     * Instead we use tree map to find the first value larger and last value
     * smaller.
     * We have a tree map to store the intervals, left boundary as key and right
     * boundary as value
     * 
     * @return
     */

    class SummaryRanges {
        // init the tree map
        private TreeMap<Integer, Integer> intervals;

        SummaryRanges() {
            intervals = new TreeMap<>();
        }

        public void addNum(int value) {
            int left = value, right = value;
            // find the last interval that has smaller left boundary than current value;
            Map.Entry<Integer, Integer> lowEntry = intervals.floorEntry(value);
            if (lowEntry != null) {
                // if this interval contains current value just skip
                if (lowEntry.getValue() >= value)
                    return;
                // if this interval is contagious to current value, we need to use existing left
                // boundary
                if (lowEntry.getValue() + 1 == value)
                    left = lowEntry.getKey();
            }
            // find the first interval that has higher left boundary than current value;
            Map.Entry<Integer, Integer> hightEntry = intervals.higherEntry(value);
            // check if we have such interval and check if the interval is contagious to
            // current value;
            if (hightEntry != null && hightEntry.getKey() == value + 1) {
                // use the existing right boundary and clear old value;
                right = hightEntry.getValue();
                intervals.remove(value + 1);
            }
            // insert new interval
            intervals.put(left, right);
            // insertion time complexity will be O(log(n))
        }

        // this part is simple no need to explain
        // Time Complexity will be O(n)
        public int[][] getIntervals() {
            int[][] res = new int[intervals.size()][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                res[index][0] = entry.getKey();
                res[index++][1] = entry.getValue();
            }
            return res;
        }

    }

}
