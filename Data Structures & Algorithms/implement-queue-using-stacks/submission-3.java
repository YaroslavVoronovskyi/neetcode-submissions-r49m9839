class MyQueue {

    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }
    
    public void push(int x) {
       firstStack.push(x);
    }
    
    public int pop() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }
    
    public int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }
    
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */