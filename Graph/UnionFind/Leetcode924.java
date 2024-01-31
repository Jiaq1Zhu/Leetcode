class Leetcode924 {

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int x) {
            this.parent = new int[x];
            this.size = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int getRank(int x) {
            return size[find(x)];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return false;
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
            return true;
        }

    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1)
                    uf.union(i, j);
            }
        }

        Arrays.sort(initial);
        int[] count = new int[n];
        for (int i : initial) {
            int part = uf.find(i);
            count[part]++;
        }

        int nodeId = Integer.MAX_VALUE;
        int curRank = 0;
        for (int i = 0; i < initial.length; i++) {
            int part = uf.find(initial[i]);
            if (count[part] == 1) {
                int rank = uf.getRank(initial[i]);
                if (rank == curRank) {
                    nodeId = Math.min(nodeId, initial[i]);
                } else if (rank > curRank) {
                    curRank = rank;
                    nodeId = initial[i];
                }
            }
        }
        if (nodeId != Integer.MAX_VALUE)
            return nodeId;
        nodeId = initial[0];
        for (int i = 1; i < initial.length; i++) {
            nodeId = Math.min(nodeId, initial[i]);
        }
        return nodeId;

    }
}