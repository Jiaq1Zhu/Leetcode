public class Leetcode648 {
    class TreeNode{
        TreeNode[] children;
        String val;
        public TreeNode(){
            this.children = new TreeNode[256];
            this.val = "";
        }
    }
    class Trie{
        TreeNode root;
        public Trie(){
            this.root = new TreeNode();
        }
        
        public void insert(String word){
            TreeNode node = this.root;
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if(node.children[c] == null){
                    node.children[c] = new TreeNode();
                }
                node = node.children[c];
            }
            node.val = word;
        }
        public String getRoot(String s){
            TreeNode node = this.root;
            for(int i = 0;i < s.length();i++){
                char c = s.charAt(i);
                if(node.children[c] == null){
                    //no root found
                    return s;
                }
                node = node.children[c];
                if(!node.val.equals(""))return node.val;
            }
            return s;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie tree = new Trie();
        for(String s:dictionary){
            tree.insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            sb.append(tree.getRoot(word));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
