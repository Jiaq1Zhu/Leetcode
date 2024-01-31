import java.util.Arrays;

public class Leetcode1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0, n = clips.length, curEnd = 0, nextEnd = 0;
        while (i < n && clips[i][0] <= curEnd) {
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time)
                return res;
        }
        return -1;
    }

}