public class Leetcode1268 {
    class Node{
        Node[] children = new Node[26];
        String Fulltext;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for(String p: products){
            Node r = root;
            for(int i = 0;i < p.length();i++){
                int index = p.charAt(i)-'a';
                if(r.children[index] == null){
                    r.children[index] = new Node();
                }
                r = r.children[index];
            }
            r.Fulltext = p;
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i < searchWord.length();i++){
            if(root == null){
                res.add(new ArrayList<>());
                continue;
            }
            root = root.children[searchWord.charAt(i)-'a'];
            res.add(getList(root,new ArrayList<>()));
        }
        return res;
    }
    private List<String> getList(Node root, List<String> list){
        if(root == null || list.size() == 3)return list;
        if(root.Fulltext != null)list.add(root.Fulltext);
        for(int i = 0;i < 26;i++){
            if(root.children[i] != null){
                getList(root.children[i],list);
            }
        }
        return list;
    }
    
}
