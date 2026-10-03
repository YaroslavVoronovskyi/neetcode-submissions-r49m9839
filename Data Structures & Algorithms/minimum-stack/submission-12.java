class MinStack {

    private long min;
    private Stack<Long> stack;

    public MinStack() {
       stack = new Stack<>();
    }
    
    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = value;
        } else {
            stack.push(value - min);
            if (value < min) {
                min = value;
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long top = stack.pop();
        if(top < 0) {
            min = min - top;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
