class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int target, int[] numbers) {
        this.k = target;
        this.minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.offer(number);
            validateMinHeapSize();
        }
    }

    public int add(int value) {
        minHeap.offer(value);
        validateMinHeapSize();
        return minHeap.peek();
    }

    private void validateMinHeapSize() {
       if (minHeap.size() > this.k) {
            minHeap.poll();
        }
    }
}
