public class Leetcode211 {
    class WordDictionary {
        class TreeNode{
            TreeNode[] children;
            boolean isWord;
            public TreeNode(){
                this.children = new TreeNode[26];
                this.isWord = false;
            }
        }
        private TreeNode root;
        public WordDictionary() {
            this.root = new TreeNode();
        }
        
        public void addWord(String word) {
            TreeNode node = this.root;
            for(int i = 0;i < word.length();i++){
                int c = word.charAt(i)-'a';
                if(node.children[c] == null){
                    node.children[c] = new TreeNode();
                }
                node = node.children[c];
            }
            node.isWord = true;
        }
        
        public boolean search(String word) {
            return find(word,root,0);
        }
        
        private boolean find(String word, TreeNode node, int index){
            if(index == word.length())return node.isWord;
            if(word.charAt(index) == '.'){
                for(TreeNode n:node.children){
                    if(n != null &&  find(word,n,index+1) == true){
                        return true;
                    }
                }
                return false;
            }else{
                int j = word.charAt(index) - 'a';
                TreeNode temp = node.children[j];
                return temp != null && find(word, temp, index + 1);
            }
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
