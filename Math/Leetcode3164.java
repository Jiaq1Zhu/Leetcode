public class Leetcode3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int maxV = Integer.MIN_VALUE;
        for (int i : nums1)
            maxV = Math.max(maxV, i);
        int limit = maxV / k;
        int[] count1 = new int[limit + 1];
        for (int i : nums1) {
            if (i % k == 0)
                count1[i / k]++;
        }

        int maxU = Integer.MIN_VALUE;
        for (int i : nums2)
            maxU = Math.max(maxU, i);
        int[] count2 = new int[maxU + 1];
        for (int i : nums2)
            count2[i]++;
        long ans = 0;
        for (int i = 1; i <= maxU; i++) {
            // we dont see this number in nums2
            if (count2[i] == 0)
                continue;
            for (int y = i; y <= limit; y += i) {
                if (count1[y] > 0)
                    ans += (long) count1[y] * count2[i];
            }
        }
        return ans;
    }
}
