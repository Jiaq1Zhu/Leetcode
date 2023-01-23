import java.util.ArrayList;
import java.util.List;

public class Growth {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1 4");
        list.add("2 3");
        list.add("4 1");
        System.out.println(countMax(list));
    }

    public static long countMax(List<String> upRights){
        long xl = Integer.parseInt(upRights.get(0).split(" ")[0]);
        long yl = Integer.parseInt(upRights.get(0).split(" ")[1]);

        for(int i = 1;i < upRights.size();i++){
            long curX = Integer.parseInt(upRights.get(i).split(" ")[0]);
            long curY = Integer.parseInt(upRights.get(i).split(" ")[1]);
            xl = Math.min(xl,curX);
            yl = Math.min(yl,curY);
        }
        return xl*yl;

    }
}
