class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : hand) {
            count.put(number, 1 + count.getOrDefault(number, 0));
        }
       PriorityQueue<Integer> heap = new PriorityQueue<>(count.keySet());
        while (!heap.isEmpty()) {
            int first = heap.peek();
            for (int index = first; index < first + groupSize; index++) {
                if (!count.containsKey(index)) {
                    return false;
                }
                count.put(index, count.get(index) - 1);
                if (count.get(index) == 0) {
                    if (index != heap.peek()) {
                        return false;
                    }
                    heap.poll();
                }
            }
        }
        return true;
    }
}
