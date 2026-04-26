public class Leetcode588 {
    class FileNode {
        boolean isFile;
        Map<String, FileNode> children = new TreeMap<>();
        StringBuilder content = new StringBuilder();
    }

    private FileNode root;

    public Leetcode588() {
        root = new FileNode();
    }

    private FileNode traverse(String path) {
        String[] parts = path.split("/");
        FileNode cur = root;
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            cur = cur.children.get(part);
        }
        return cur;
    }

    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        FileNode curr = root;
        String[] parts = path.split("/");
        String lastPart = "";
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            curr = curr.children.get(part);
            lastPart = part;
        }

        if (curr.isFile) {
            res.add(lastPart);
        } else {
            res.addAll(curr.children.keySet());
        }
        return res;
    }

    public void mkdir(String path) {
        String[] parts = path.split("/");
        FileNode cur = root;
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            cur.children.putIfAbsent(part, new FileNode());
            cur = cur.children.get(part);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        FileNode cur = root;
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            cur.children.putIfAbsent(part, new FileNode());
            cur = cur.children.get(part);
        }
        cur.isFile = true;
        cur.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        FileNode fileNode = traverse(filePath);
        return fileNode.content.toString();
    }
}
