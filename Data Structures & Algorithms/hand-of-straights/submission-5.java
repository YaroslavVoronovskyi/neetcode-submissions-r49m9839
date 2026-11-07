class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int number : hand) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(count.keySet());
        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();
            for (int index = first; index < first + groupSize; index++) {
                if (!count.containsKey(index)) {
                    return false;
                }
                count.put(index, count.get(index) - 1);
                if (count.get(index) == 0) {
                    if (index != minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}
