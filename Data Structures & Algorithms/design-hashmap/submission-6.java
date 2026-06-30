class ListNode {
    int key; 
    int value;
    ListNode next;

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);
    }
}

public class MyHashMap {
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for (int index = 0; index < 1000; index++) {
            map[index] = new ListNode();
        }
    }

    private int hash(int key) {
        return key % map.length;
    }

    public void put(int key, int value) {
        ListNode current = map[hash(key)];
        while (current.next != null) {
            if (current.next.key == key) {
                current.next.value = value;
                return;
            }
            current = current.next;
        }
        current.next = new ListNode(key, value, null);
    }

    public int get(int key) {
        ListNode current = map[hash(key)].next;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        ListNode current = map[hash(key)];
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */