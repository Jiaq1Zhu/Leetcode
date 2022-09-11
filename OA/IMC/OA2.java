import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class OA2 {
    public static void solution(int[] arrival, int[] street, int n){
        PriorityQueue<int[]> time_car = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Deque<int[]> main_street = new ArrayDeque<>();
        Deque<int[]> first_street = new ArrayDeque<>();
        int[] ans = new int[n];

        for(int i = 0;i < n;i++){
            // put all cars into pq, sort them by their arrive time.
            time_car.add(new int[]{arrival[i],i});
        }
        int curTime = 0, preCar = -1;
        int[] cur_time_car = new int[2];
        while(!time_car.isEmpty()|| !main_street.isEmpty()||!first_street.isEmpty()){
            // no car is waiting on either street
            if(main_street.isEmpty() && first_street.isEmpty()){
                // if arrival time is not current ime, means not previous car pass intersection
                if(time_car.peek()[0] != curTime)preCar = -1;
                // set current time to the car passing time;
                curTime = time_car.peek()[0];
            }
            while(!time_car.isEmpty() && time_car.peek()[0] == curTime){
                // so there is a car arrive at current time
                cur_time_car = time_car.poll();
                // check if cars arrive at the same time
                // put them into queue.
                if(street[cur_time_car[1]] == 0)main_street.add(cur_time_car);
                else if(street[cur_time_car[1]] == 1)first_street.add(cur_time_car);
            }
            if((preCar == -1 || preCar == 1 || main_street.isEmpty()) && !first_street.isEmpty()){
                // if no previous car, or previous car pass on first avenue or no car is waiting on main street.
                int[] cur_first_street = first_street.poll();
                ans[cur_first_street[1]] = curTime++;
                preCar = 1;
            }else if((preCar == 0 || first_street.isEmpty()) && !main_street.isEmpty()){
                //
                int[] cur_main_street = main_street.poll();
                ans[cur_main_street[1]] = curTime++;
                preCar = 0;
            }
        }
        for(int i = 0;i < ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
