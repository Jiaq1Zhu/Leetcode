public class Leetcode588 {
    class Node {
        String name;
        Map<String, Node> nodeByName = new TreeMap<>();
        boolean isFile = false;
        StringBuilder content = new StringBuilder();

        public Node(String name) {
            this.name = name;
        }
    }

    Node root;

    public FileSystem() {
        this.root = new Node("");
    }

    public List<String> ls(String path) {
        Node n = traversePath(path);
        return n.isFile ? List.of(n.name) : List.copyOf(n.nodeByName.keySet());
    }

    public void mkdir(String path) {
        traversePath(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node n = traversePath(filePath);
        n.content.append(content);
        n.isFile = true;
    }

    public String readContentFromFile(String filePath) {
        return traversePath(filePath).content.toString();
    }

    public Node traversePath(String path) {
        Node cur = root;
        String[] parts = path.split("/");
        int[] depth = new int[] { 1 };
        while (depth[0] < parts.length) {
            cur = cur.nodeByName.computeIfAbsent(parts[depth[0]], k -> new Node(parts[depth[0]]));
            depth[0]++;
        }
        return cur;
    }
}
