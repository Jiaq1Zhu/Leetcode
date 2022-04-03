public class Leetcode677 {
    class MapSum {
        class TreeNode{
            TreeNode[] children;
            int score;
            public TreeNode(){
                children = new TreeNode[26];
                score = 0;
            }
        }
        // we use a map to store current value of a string, incase we need to modifiy it.
        Map<String,Integer>map;
        TreeNode root;
        public MapSum() {
            this.map = new HashMap<>();
            this.root = new TreeNode();
        }
        
        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key,0);
            TreeNode node = this.root;
            map.put(key,val);
            for(int i = 0;i <key.length();i++){
                int c = key.charAt(i)-'a';
                if(node.children[c] == null){
                    node.children[c] = new TreeNode();
                }
                node = node.children[c];
                node.score += delta;
            }
        }
        
        public int sum(String prefix) {
            TreeNode node = this.root;
            for(int i = 0;i <prefix.length();i++){
                 int c = prefix.charAt(i)-'a';
                if(node.children[c] == null){
                    return 0;
                }
                node = node.children[c];
            }
            return node.score;
        }
    }
    
    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}
