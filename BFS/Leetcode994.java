package BFS;

public class Leetcode994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            if(grid == null || grid.length ==0 || grid[0].length == 0)return 0;
            int x = grid.length;
            int y = grid[0].length;
            int fresh = 0;
            Queue<int[]> queue = new LinkedList<>();
            for(int i = 0;i < x;i++){
                for(int j = 0;j < y;j++){
                    if(grid[i][j] == 2){
                        queue.offer(new int[]{i,j});
                    }
                    if(grid[i][j] == 1)fresh++;
                }
            }
            if(fresh == 0)return 0;
            int count = 0;
            while(!queue.isEmpty()){
                int size  = queue.size();
                count++;
                for(int i = 0;i < size;i++){
                    int[] coord = queue.poll();
                    if(inBound(coord[0]+1,coord[1],x,y) && grid[coord[0]+1][coord[1]]==1){
                        grid[coord[0]+1][coord[1]] = 2;
                        fresh--;
                        queue.offer(new int[]{coord[0]+1,coord[1]});
                    }if(inBound(coord[0]-1,coord[1],x,y) && grid[coord[0]-1][coord[1]]==1){
                        grid[coord[0]-1][coord[1]] = 2;
                        fresh--;
                        queue.offer(new int[]{coord[0]-1,coord[1]});
                    }if(inBound(coord[0],coord[1]+1,x,y) && grid[coord[0]][coord[1]+1] == 1){
                        grid[coord[0]][coord[1]+1] = 2;
                        fresh--;
                        queue.offer(new int[]{coord[0],coord[1]+1});
                    }if(inBound(coord[0],coord[1]-1,x,y) && grid[coord[0]][coord[1]-1] == 1){
                        grid[coord[0]][coord[1]-1] = 2;
                        fresh--;
                        queue.offer(new int[]{coord[0],coord[1]-1});
                    }
                }
            }
            if(fresh == 0)return count-1;
            return -1;
            
        }
        private boolean inBound(int i,int j,int x, int y){
            if(i < 0|| i >= x)return false;
            if(j < 0 || j >= y)return false;
            return true;
        }
    }
}
