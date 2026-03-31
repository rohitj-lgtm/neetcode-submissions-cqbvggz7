class Node {
	int val;
	int key;
	Node next;
	Node prev;
	Node(int key, int val) {
		this.val = val;
		this.key = key;
	}
}

class LRUCache {
	Node head, tail;
	HashMap<Integer, Node> cache;
	int size;

    public LRUCache(int capacity) {
    	this.size = capacity;
    	this.cache = new HashMap<>();
    	this.head = new Node(0, 0);
    	this.tail = new Node(0, 0);
    	this.head.next = this.tail;
    	this.tail.prev = this.head;
    }

    private void remove(Node n){
    	Node prev = n.prev;
    	Node next = n.next;
    	prev.next = next;
    	next.prev = prev;
    }

    private void insert(Node n){
    	Node prev = tail.prev;
    	prev.next = n;
    	n.prev = prev;
    	n.next = tail;
    	tail.prev = n;
    }
    
    public int get(int key) {
    	if(this.cache.containsKey(key)){
    		Node n = this.cache.get(key);
    		this.remove(n);
    		this.insert(n);
    		return n.val;
    	}
    	return -1;
    }
    
    public void put(int key, int value) {
    	if(this.cache.containsKey(key)){
    		Node n = this.cache.get(key);
    		n.val = value;
    		this.remove(n);
    		this.insert(n);
    	} else {
	    	Node n = new Node(key, value);
	    	this.cache.put(key, n);
	    	this.insert(n);
    	}
    	if(this.cache.size() > this.size){
    		Node lru = this.head.next;
    		this.remove(lru);
    		cache.remove(lru.key);
    	}
    }
}
