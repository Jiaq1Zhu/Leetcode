import java.util.ArrayList;

public class Leetcode77 {
    /**
     * In this problem, we need to find all combination with length of k;
     * The array is from 1 to n;
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }

    public void dfs(int n, int k, int start){
        /**
         * It is a very typical dfs
         */
        if(list.size() == k){
            // In this case we found valid combination
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i<=n;i++){
            list.add(i);
            dfs(n,k,i+1);
            list.remove(list.size()-1);
        }

    }
}
