class MyHashSet {

    private int[] data;

    public MyHashSet() {
        data = new int[31251];
    }
    
    public void add(int key) {
        data[key / 32] |= getMask(key);
    }
    
    public void remove(int key) {
        if (contains(key)) {
            data[key / 32] ^= getMask(key);
        }
    }
    
    public boolean contains(int key) {
        return (data[key / 32] & getMask(key)) != 0;
    }

    private int getMask(int key) {
        return 1 << (key % 32);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */