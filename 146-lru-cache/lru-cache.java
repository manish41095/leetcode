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
        //Created dummy node
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        Node node = cache.get(key);

        if (node == null)
            return -1;

        // This node was accessed, so it becomes most recently used
        moveToFront(node);

        return node.value;

    }

    public void put(int key, int value) {
        Node existingNode = cache.get(key);

        if (existingNode != null) {
            existingNode.value = value;
            moveToFront(existingNode);
            return;
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addFirst(newNode);

        // Remove the least recently used entry if capacity is exceeded
        if (cache.size() > capacity) {
            Node lruNode = removeLast();
            cache.remove(lruNode.key);
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