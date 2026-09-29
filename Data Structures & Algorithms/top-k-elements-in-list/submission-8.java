class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[] {entry.getValue(), entry.getKey()});
            if (heap.size() > key) {
                heap.poll();
            }
        }
        int[] array = new int[key];
        for (int index = 0; index < key; index++) {
            array[index] = heap.poll()[1];
        }
        return array;
    }
}
