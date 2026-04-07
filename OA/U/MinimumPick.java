public class MinimumPick {
    /*
     * 给定n个坐标，和一个磁力d，每次可以选择一个坐标，磁力会把所有距离这个坐标x轴或者是y轴上距离小于等于d的坐标吸引过来，
     * 求最少需要选择多少个坐标才能把所有坐标都吸引过来
     * 思路： 创建一个并查集，便利坐标，如果两个坐标之间的距离小于等于d，就把它们合并到同一个集合中。最后统计有多少个不同的集合就可以了。
     */

    static class UnionFind {
        int[] root;
        int count;

        public UnionFind(int n) {
            root = new int[n];
            count = n;
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
            if (rootX != rootY) {
                root[rootY] = rootX;
                count--;
                return true;
            }
            return false;
        }
    }

    public static int minPick(int n, int d, List<Integer> x, List<Integer> y) {
        UnionFind uf = new UnionFind(n);
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // 先按照x坐标排序，如果x坐标相同，就按照y坐标排序
        // 排序的复杂度是O(nlogn)，合并的复杂度是O(n)，总的复杂度是O(nlogn)
        Arrays.sort(indices, (a, b) -> {
            if (x.get(a).equals(x.get(b))) {
                return y.get(a) - y.get(b);
            } else {
                return x.get(a) - x.get(b);
            }
        });
        // 遍历的复杂度是O(n)，每次合并的复杂度是O(1)，总的复杂度是O(n)
        for (int i = 0; i < n - 1; i++) {
            int cur = indices[i];
            int next = indices[i + 1];
            if (x.get(cur).equals(x.get(next)) && Math.abs(y.get(cur) - y.get(next)) <= d) {
                uf.union(cur, next);
            }

        }
        // 先按照y坐标排序，如果y坐标相同，就按照x坐标排序
        Arrays.sort(indices, (a, b) -> {
            if (y.get(a).equals(y.get(b))) {
                return x.get(a) - x.get(b);
            } else {
                return y.get(a) - y.get(b);
            }
        });
        // 遍历的复杂度是O(n)，每次合并的复杂度是O(1)，总的复杂度是O(n)
        for (int i = 0; i < n - 1; i++) {
            int cur = indices[i];
            int next = indices[i + 1];
            if (y.get(cur).equals(y.get(next)) && Math.abs(x.get(cur) - x.get(next)) <= d) {
                uf.union(cur, next);
            }
        }
        // 最后统计有多少个不同的集合就可以了， 因为每一次的count更新都是在合并的时候进行的，所以最后的count就是不同集合的数量
        // 整个算法的最终复杂度是O(nlogn)，因为排序的复杂度是O(nlogn)，其他操作的复杂度都是O(n)
        return uf.count;
    }
}
