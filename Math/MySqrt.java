public class MySqrt {
    int mySqrt(int x){
        if(x <= 0 || x == 1)return x;
        double err = 1e-15;
        double t = x;
        while(Math.abs(t-x/t) > err * t){
            t = (t + x/t)/2;
        }
        return (int)t;
    }
}
