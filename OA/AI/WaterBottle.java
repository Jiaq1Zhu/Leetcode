public class WaterBottle {
        public int numWaterBottles(int numBottles, int numExchange) {
            int count = 0;
            while(numBottles >= numExchange){
                numBottles -= numExchange;
                count += numExchange;
                numBottles ++;
            }
            count += numBottles;
            return count;
        }
}
