class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int target, int[] numbers) {
        this.k = target;
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
        if (minHeap.size() > this.k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }


}
