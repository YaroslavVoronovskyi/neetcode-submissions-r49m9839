class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            result.add(new int[] {entry.getValue(), entry.getKey()});
        }
        result.sort((a, b) -> b[0] - a[0]);
        int[] array = new int[key];
        for (int index = 0; index < key; index++) {
            array[index] = result.get(index)[1];
        }
        return array;
    }
}
