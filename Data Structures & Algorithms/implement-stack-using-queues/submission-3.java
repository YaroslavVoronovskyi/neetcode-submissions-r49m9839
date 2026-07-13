class MyStack {

    private Queue<Object> queue;

    public MyStack() {
        queue = null;
    }
    
    public void push(int x) {
        Queue<Object> newQueue = new LinkedList<>();
        newQueue.add(x);
        newQueue.add(queue);
        queue = newQueue;
    }
    
    public int pop() {
        if (queue == null) {
            return -1;
        }
        int top = (int) queue.poll();
        queue = (Queue<Object>) queue.poll();
        return top;
    }
    
    public int top() {
        if (queue == null) {
            return -1;
        }
        return (int) queue.peek();
    }
    
    public boolean empty() {
        return queue == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */