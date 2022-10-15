public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)return res;
        String path = "";
        dfs(n,n,path,res);
        return res;
    }
    
    public void dfs(int left, int right,String path, List<String> res){
        if(left < 0 || right < 0)return;
        // deal with left bracket first
        if(left > 0){
            String newPath = path+"(";
            dfs(left-1,right,newPath,res);
        }
        // then right bracket
        if(left < right){
            String newPath = path+")";
            right--;
            // if right == 0 means we found a corrent premutation
            if(right == 0)res.add(newPath);
            dfs(left,right,newPath,res);
        }
    }
}
