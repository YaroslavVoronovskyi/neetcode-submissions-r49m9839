class ListNode {
    int key;
    int value;
    int freq;
    ListNode prev;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    } 
}

class DoublyLinkedList {
    private ListNode left;
    private ListNode right;
    private int size;

    DoublyLinkedList() {
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }

    public int length() {
        return size;
    }

    public void pushRight(ListNode node) {
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        size++;
    }

    public void pop(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public ListNode popLeft() {
        ListNode node = this.left.next;
        pop(node);
        return node;
    }
}

class LFUCache {

    private int capacity;
    private int lfuCount;
    private Map<Integer, ListNode> nodeMap;
    private Map<Integer, DoublyLinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCount = 0;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        ListNode node = nodeMap.get(key);
        counter(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);
            node.value = value;
            counter(node);
            return;
        }
        if (nodeMap.size() == capacity) {
            ListNode toRemove = listMap.get(lfuCount).popLeft();
            nodeMap.remove(toRemove.key);
        }
        ListNode node = new ListNode(key, value);
        nodeMap.put(key, node);
        listMap.putIfAbsent(1, new DoublyLinkedList());
        listMap.get(1).pushRight(node);
        lfuCount = 1;
    }

    private void counter(ListNode node) {
        int count = node.freq;
        listMap.get(count).pop(node);
        if (count == lfuCount && listMap.get(count).length() == 0) {
            lfuCount++;
        }
        node.freq++;
        listMap.putIfAbsent(node.freq, new DoublyLinkedList());
        listMap.get(node.freq).pushRight(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */