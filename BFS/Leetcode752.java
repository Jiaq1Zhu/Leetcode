public class Leetcode752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if (dead.contains(start))
            return -1;
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target))
                    return step;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!dead.contains(up) && !visited.contains(up)) {
                        visited.add(up);
                        q.offer(up);
                    }
                    String down = minusOne(cur, j);
                    if (!dead.contains(down) && !visited.contains(down)) {
                        visited.add(down);
                        q.offer(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9')
            chars[j] = '0';
        else
            chars[j]++;
        return new String(chars);
    }

    private String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0')
            chars[j] = '9';
        else
            chars[j]--;
        return new String(chars);
    }
}
