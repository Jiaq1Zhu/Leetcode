public class Leetcode208 {
    TreeNode root;
    class TreeNode{
        TreeNode[] children;
        String s;
        public TreeNode(){
            this.children = new TreeNode[256];
            this.s = "";
        }
    }
    public Trie() {
        this.root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode node = this.root;
        for(int i = 0;i < word.length();i++){
            char c= word.charAt(i);
            if(node.children[c] == null){
                node.children[c] = new TreeNode();
            }
            node = node.children[c];
        }
        node.s = word;
    }
    
    public boolean search(String word) {
        TreeNode node = this.root;
        for(int i = 0;i < word.length();i++){
            char c= word.charAt(i);
            if(node.children[c] == null){
                return false;
            }
            node = node.children[c];    
        }
        return node.s.equals(word);
    }
    
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(int i = 0;i < prefix.length();i++){
            char c= prefix.charAt(i);
            if(node.children[c] == null){
                return false;
            }
            node = node.children[c];
        }
        return true;
    }
}
