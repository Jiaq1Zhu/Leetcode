import java.util.ArrayList;
import java.util.List;

class MinDiff {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        a.add("a");
        a.add("jk");
        a.add("abb");
        a.add("mn");
        a.add("abc");

        
        b.add("bb");
        b.add("kj");
        b.add("bbc");
        b.add("op");
        b.add("def");
        List<Integer> result = getMinimumDifference(a, b);
        for(int i = 0;i < result.size();i++){
            System.out.println(result.get(i));
        }
    }
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b){
        String s1, s2;
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < a.size();i++){
            s1 = a.get(i);
            s2 = b.get(i);
            res.add(count(s1,s2));
        }
        return res;
    }

    static int count(String a, String b){
        if(a.length() != b.length())return -1;
        int count = 0;
        int[] hash = new int[256];
        for(int i = 0;i < a.length();i++){
            hash[a.charAt(i)]++;
            hash[b.charAt(i)]--;
        }

        for(int i = 0;i < hash.length;i++){
            if(hash[i] != 0){
                count += Math.abs(hash[i]);
            }
        }
        return count/2;
    }
}