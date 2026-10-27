class Solution {
    public int findKthLargest(int[] numbers, int key) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.offer(number);
            if (minHeap.size() > key) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
