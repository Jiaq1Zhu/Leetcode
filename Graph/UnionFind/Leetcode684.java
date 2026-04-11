public class Leetcode684 {
    class UnionFind {
        int[] root;

        public UnionFind(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return false;
            root[rootX] = rootY;
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int cur = edge[0] - 1;
            int next = edge[1] - 1;
            boolean res = uf.union(cur, next);
            if (!res)
                return edge;
        }
        return new int[] {};
    }
}
