class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > key) {
                heap.poll();
            }
        }
        int[] result = new int[key];
        for (int index = 0; index < key; index++) {
            result[index] = heap.poll()[1];
        }
        return result;
    }
}
