class Leetcode1804{
    class Trie {
        TreeNode root;
        class TreeNode{
            TreeNode[] children;
            int startWith;
            int equals;
            public TreeNode(){
                this.children = new TreeNode[256];
                this.startWith = 0;
                this.equals = 0;
            }
        }
        public Trie() {
            this.root = new TreeNode();
        }
        
        public void insert(String word) {
            TreeNode node = this.root;
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if(node.children[c] == null){
                    node.children[c] = new TreeNode();
                }
                node = node.children[c];
                node.startWith++;
            }
            node.equals++;
        }
        
        public int countWordsEqualTo(String word) {
            TreeNode node = this.root;
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if(node.children[c] == null){
                    return 0;
                }
                node = node.children[c];
            }
            return node.equals;
        }
        
        public int countWordsStartingWith(String prefix) {
            TreeNode node = this.root;
            for(int i = 0;i < prefix.length();i++){
                char c = prefix.charAt(i);
                if(node.children[c] == null){
                    return 0;
                }
                node = node.children[c];
            }
            return node.startWith;
        }
        
        public void erase(String word) {
            TreeNode node = this.root;
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if(node.children[c] == null){
                    return;
                }
                node = node.children[c];
                node.startWith--;
            }
            node.equals--;
        }
    }
    
}