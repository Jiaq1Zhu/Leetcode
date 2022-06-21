class LongestWorkSlot{
    public char findLongestWorkingSlot(int[][] slots){
        // let's check null case;
        if(slots == null ||slots.length == 0)return '0';
        // lets create an array to map the character
        char[] chars = "abcdefghijklmnopqrstuvwxyz".split();
        // lets creaet an arrayh to store total worktime
        int[] times = new int[26];
        //first every work works zero time
        int max = 0;
        // let's have a number to store current longest worker
        int maxWorkerNum = 0;
        // let's have a initial start time as 0;
        int start = 0;
        for(int[] slot:slots){
            int workerNum = slot[0];
            int endtime = slot[1];
            int workTime = endTime-startTime;
            times[workerNum] += workTime;
            if(times[workerNum] > max){
                max = times[workerNum];
                maxWorkerNum = workerNum;
            }
            
        }
        return chars[maxWorkerNum];
    }
}