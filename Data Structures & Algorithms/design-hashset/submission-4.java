class MyHashSet {

    private final ListNode[] set;

    public MyHashSet() {
        set = new ListNode[10000];
        for (int index = 0; index < set.length; index++) {
            set[index] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        ListNode current = set[key % set.length];
        while (current.next != null) {
            if (current.next.key == key) {
                return;
            }
            current = current.next;
        }
        current.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode current = set[key % set.length];
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode current = set[key % set.length];
        while (current.next != null) {
            if (current.next.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static class ListNode {
        
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */