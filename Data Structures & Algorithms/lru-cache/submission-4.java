class LRUCache {

    private Map<Integer, Node> cache;
    private int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.previous = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;
    }

    private void insert(Node node) {
        Node previous = this.right.previous;
        previous.next = node;
        node.previous = previous;
        node.next = this.right;
        this.right.previous = node;
    }
}

public class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}
