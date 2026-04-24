public class Leetcode773 {
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j] + "");
            }
        }
        String start = sb.toString();
        int[][] neighbors = {
                { 1, 3 },
                { 0, 2, 4 },
                { 1, 5 },
                { 0, 4 },
                { 1, 3, 5 },
                { 2, 4 }
        };

        Queue<String> q = new LinkedList<>();
        visited.add(start);
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target))
                    return step;
                int idx = cur.indexOf('0');
                for (int j : neighbors[idx]) {
                    String next = swap(cur, idx, j);
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
