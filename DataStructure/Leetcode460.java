public class Leetcode460 {
    class LFUCache {
        class Node{
            Node prev;
            Node next;
            int val;
            int key;
            int freq;
            public Node(int key, int val){
                // This part is the same as LRU except that we have freq attribute
                this.key = key;
                this.val = val;
                this.freq = 1;
            }
        }
        
        class DoubleLinkedList{
            Node head;
            Node tail;
            int listSize;
            public DoubleLinkedList(){
                // we have dummy head and tail
                head = new Node(0,0);
                tail = new Node(0,0);
                head.next = tail;
                listSize = 0;
            }
            public void put(Node n){
                Node next = head.next;
                head.next = n;
                n.next = next;
                next.prev = n;
                n.prev = head;
                listSize++;
            }
            public void remove(Node n){
                n.prev.next = n.next;
                n.next.prev = n.prev;
                listSize--;
            }
        }
        Map<Integer,Node> cache = new HashMap<>();
        Map<Integer,DoubleLinkedList> freqMap = new HashMap<>();
        int curSize;
        int minFreq;
        int capacity;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.curSize = 0;
            this.minFreq = 0;
        }
        
        private void update(Node n){
            //This function will update n, to its new frequency;
            int curFreq = n.freq;
            DoubleLinkedList curList = freqMap.get(curFreq);
            curList.remove(n);
            // check if it is last item with least frequency;
            if(curFreq == minFreq && curList.listSize == 0)minFreq++;
            n.freq++;
            DoubleLinkedList newList = freqMap.getOrDefault(n.freq, new DoubleLinkedList());
            newList.put(n);
            freqMap.put(n.freq,newList);
        }
        
        public int get(int key) {
            if(cache.containsKey(key)){
                Node n = cache.get(key);
                update(n);
                return n.val;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            //corner case check;
            if(capacity == 0)return;
            if(cache.containsKey(key)){
                Node n = cache.get(key);
                n.val = value;
                update(n);
            }else{
                curSize++;
                if(curSize > capacity){
                    // remove the node with least freq
                    DoubleLinkedList minList = freqMap.get(minFreq);
                    cache.remove(minList.tail.prev.key);
                    minList.remove(minList.tail.prev);
                    curSize--;
                }
                Node newNode = new Node(key,value);
                minFreq = 1;
                DoubleLinkedList newList = freqMap.getOrDefault(1,new DoubleLinkedList());
                newList.put(newNode);
                cache.put(key,newNode);
                freqMap.put(1,newList);
            }
        }
    }
    
    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
