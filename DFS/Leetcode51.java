class Leetcode51{
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] col = new int[n];
        if(n <= 0)return res;
        dfs(0,col,res);
        return res;
    }
    
    public void dfs(int row,int[] col, List<List<String>> res){
        int n = col.length;
        if(row == n){
            // we solve the last queen
            // expand current col into line
            List<String> list = new ArrayList<>();
            for(int i = 0;i < row;i++){
                // for each line find its queen position
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < col.length;j++){
                    // ith queen is at (i,col[i]);
                    if(col[i] == j)sb.append('Q');
                    // other will just be empty
                    else sb.append('.');
                }
                // add current line into matrix
                list.add(sb.toString());
            }
            // add current matrix into result
            res.add(new ArrayList<>(list));
        }else{
            for(int i = 0;i < n;i++){
                col[row] = i;
                if(isValid(col,row)){
                    dfs(row+1,col,res);
                }
            }
        }
    }
    
    private boolean isValid(int[] col,int row){
        for(int i = 0;i < row;i++){
            // for every col, check if there is a queen in the same col.
            // because every queen must occpy a row.
            // so we assume queen i will take i row;
            // wee need to check every queen before current queen
            // to check diaganal line, the diff between row and col should the same 
            // if they in a diaganal
            if(col[row] == col[i] || Math.abs(row-i) == Math.abs(col[row]-col[i]))return false;
        }
        return true;
    }
}