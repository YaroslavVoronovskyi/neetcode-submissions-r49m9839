class FreqStack {
    private Map<Integer, Integer> map;
    private Map<Integer, Stack<Integer>> stacks;
    private int maxCount;

    public FreqStack() {
        map = new HashMap<>();
        stacks = new HashMap<>();
        maxCount = 0;
    }
    
    public void push(int value) {
        int valueCount = map.getOrDefault(value, 0) + 1;
        map.put(value, valueCount);
        if (valueCount > maxCount) {
            maxCount = valueCount;
            stacks.putIfAbsent(valueCount, new Stack<>());
        }
        stacks.get(valueCount).push(value);
    }
    
    public int pop() {
        int result = stacks.get(maxCount).pop();
        map.put(result, map.get(result) - 1);
        if (stacks.get(maxCount).isEmpty()) {
            maxCount--;
        }
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */