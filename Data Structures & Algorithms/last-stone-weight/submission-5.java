class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            minHeap.offer(stone);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if (second < first) {
                minHeap.offer(first - second);
            }
        }

        minHeap.offer(0);
        return minHeap.peek();
    }
}
