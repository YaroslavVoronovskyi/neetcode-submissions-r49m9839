class KthLargest {

    private PriorityQueue<Integer> minHeap;
    int target;

    public KthLargest(int target, int[] numbers) {
        this.target = target;
        this.minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.offer(number);
            if (minHeap.size() > target) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int value) {
        minHeap.offer(value);
        if (minHeap.size() > target) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
