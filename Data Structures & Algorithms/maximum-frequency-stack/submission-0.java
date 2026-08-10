class FreqStack {
    private Map<Integer, Integer> map;
    private List<Integer> stack;

    public FreqStack() {
        map = new HashMap<>();
        stack = new ArrayList<>();
    }
    
    public void push(int value) {
        stack.add(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
    
    public int pop() {
        int maxCount = Collections.max(map.values());
        int index = stack.size() - 1;
        while (map.get(stack.get(index)) != maxCount) {
            index--;
        }
        int value = stack.remove(index);
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