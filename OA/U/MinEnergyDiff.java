public class MinEnergyDiff {
    static class Status {
        long time;
        long energy;

        public Status(long time, long energy) {
            this.time = time;
            this.energy = energy;
        }
    }

    public static long getMinDiff(int n, int e1, int t1, int e2, int c) {

        Status[] liftStatus = new Status[n + 1];
        liftStatus[0] = new Status(0, 0);
        for (int i = 1; i <= n; i++) {
            liftStatus[i] = new Status((long) i * t1, (long) i * e1);
        }
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            long tLift = liftStatus[i].time;
            long eLift = liftStatus[i].energy;
            long tClimb = 0;
            for (int j = i + 1; j <= n; j++) {
                if (eLift <= 0)
                    break;
                long cost = (eLift + c - 1) / c;
                tClimb += cost;
                eLift = Math.max(0, eLift - e2);

            }
            long diff = Math.abs(tLift - tClimb);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
