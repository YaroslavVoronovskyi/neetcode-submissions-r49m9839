class FreqStack {
    private Map<Integer, Integer> map;
    private List<Stack<Integer>> stacks;

    public FreqStack() {
        map = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }
    
    public void push(int value) {
        int valueCount = map.getOrDefault(value, 0) + 1;
        map.put(value, valueCount);
        if (valueCount == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(valueCount).push(value);
    }
    
    public int pop() {
        Stack<Integer> topStack = stacks.get(stacks.size() - 1);
        int result = topStack.pop();
        map.put(result, map.get(result) - 1);
        if (topStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
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