public class Leetcode1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // This is a actually a hard problem with alot of code if you want to do it in dijkstra (O(v^2))
        // Now it is tagged as medium because Floyd Algorithm can work(O(N^3))
        // So let's first have the simple solution done
        
        // we have a 2d array to store the distance from i to j in dis[i][j]
        int[][] dis = new int[n][n];
        // fill all distance with max distance first as initilization
        for(int[] row:dis){
            Arrays.fill(row,10001);
        }
        // then we update distance that is directly connected;
        for(int[] e:edges){
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
        }
        // set distance to itself to 0
        for(int i = 0;i < n;i++){
            dis[i][i] = 0;
        }
        // update distance with brute force
        for(int k = 0;k < n;k++){
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    dis[i][j] = Math.min(dis[i][j],dis[i][k] + dis[k][j]);
                }
            }
        }
        //set a min number of connected cities within distance
        int min = n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j)
                if (dis[i][j] <= distanceThreshold)
                    ++count;
            if (count <= min) {
                res = i;
                min = count;
            }
        }
        return res;
    }
}
