import java.util.concurrent.atomic.AtomicIntegerArray;

public class Leetcode362 {
    class SingleTheadHitCounter {
        int[] hits;
        int[] times;
        int bucketSize;

        public SingleTheadHitCounter(int bucketSize) {
            hits = new int[bucketSize];
            times = new int[bucketSize];
            this.bucketSize = bucketSize;
        }

        public void hit(int timestamp) {
            int index = timestamp % bucketSize;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int count = 0;
            for (int i = 0; i < bucketSize; i++) {
                if (timestamp - times[i] < bucketSize) {
                    count += hits[i];
                }
            }
            return count;
        }
    }

    public class MultiThreadHitCounter {
        private final int BUCKET_SIZE;
        private AtomicIntegerArray times;
        private LongAdder[] hits;

        public MultiThreadHitCounter(int bucketSize) {
            this.BUCKET_SIZE = bucketSize;
            times = new AtomicIntegerArray(bucketSize);
            hits = new LongAdder[bucketSize];
            for (int i = 0; i < bucketSize; i++) {
                hits[i] = new LongAdder();
            }
        }

        public void hit(int timestamp) {
            int index = timestamp % BUCKET_SIZE;
            int lastTime = times.get(index);
            if (lastTime != timestamp) {
                synchronized (hits[index]) {
                    // double check on time after acquiring lock
                    if (times.get(index) != timestamp) {
                        times.set(index, timestamp);
                        hits[index].reset();
                        hits[index].increment();
                    } else {
                        hits[index].increment();
                    }
                }
            }
            hits[index].increment();
        }

        public int getHits(int timestamp) {
            int count = 0;
            for (int i = 0; i < BUCKET_SIZE; i++) {
                if (timestamp - times.get(i) < BUCKET_SIZE) {
                    count += hits[i].sum();
                }
            }
            return count;
        }
    }
}
