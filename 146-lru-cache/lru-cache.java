class LRUCache {

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize dummy head and tail to simplify boundary edge-cases
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
         if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // This node was accessed, so it becomes most recently used
        moveToFront(node);

        return node.value;

    }

    public void put(int key, int value) {
         if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update value
            moveToFront(node);   // Mark as most recently used
        } else {
            // Evict if cache is at maximum capacity
            if (cache.size() == capacity) {
                Node lruNode = tail.prev; // The node right before dummy tail
                removeNode(lruNode);
                cache.remove(lruNode.key);
            }
            
            // Insert the new key-value pair
            Node newNode = new Node(key, value);
            addFirst(newNode);
            cache.put(key, newNode);
        }

    }

    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move an accessed node to the front
    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    // Remove and return the least recently used node
    private Node removeLast() {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */