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
        while (firstStack.size() > 1) {
            secondStack.push(firstStack.pop());
        }
        int result = firstStack.pop();
        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
        return result;
    }
    
    public int peek() {
        while (firstStack.size() > 1) {
            secondStack.push(firstStack.pop());
        }
        int result = firstStack.peek();
        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
        return result;
    }
    
    public boolean empty() {
        return firstStack.isEmpty();
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