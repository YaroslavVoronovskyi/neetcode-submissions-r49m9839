class FreqStack {
    private PriorityQueue<int[]> heap;
    private Map<Integer, Integer> map;
    private int index;

    public FreqStack() {
        heap = new PriorityQueue<>((a, b) -> 
        a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1])
        );
        map = new HashMap<>();
        index = 0;
    }
    
    public void push(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        heap.offer(new int[]{map.get(value), index++, value});
    }
    
    public int pop() {
        int[] top = heap.poll();
        int value = top[2];
        map.put(value, map.get(value) - 1);
        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */