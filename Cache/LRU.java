class LRU{
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    class DoubleLinkedList{
        Node head;
        Node tail;
        public void put(Node n){
            n.next = head;
            n.prev = null;
            if(head == null)tail = n;
            else head.prev = n;
            head = n;
        }
        public void remove(Node n){
            if(n == head)head = head.next;
            if(n == tail)tail = tail.prev;
            if(n.prev != null)n.prev.next = n.next;
            if(n.next != null)n.next.prev = n.prev;
        }
    }
    int capacity;
    Map<Integer,Node> cache = new HashMap<>();
    DoubleLinkedList dll = new DoubleLinkedList();
    public LRU(int capacity){
        this.capacity = capacity;
    }
    public int get(int key){
        if(cache.containsKey){
            Node n = cache.get(key);
            dll.remove(n);
            dll.push(n);
            return n.val;
        }return -1;
    }
    public void push(int key,int val){
        if(cache.containsKey){
            dll.remove(cache.get(key));
        }
        else if(cache.size() >= capacity){
            Node remove = dll.tail;
            cache.remove(remove.key);
            dll.remove(remove);
        }
        Node n = new Node(key,val);
        dll.push(n);
        cache.put(key,n);
    }
}