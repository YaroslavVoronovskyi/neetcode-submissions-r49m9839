class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        List<int[]> array = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            array.add(new int[] {entry.getValue(), entry.getKey()});
        }
        array.sort((a, b) -> b[0] - a[0]);

        int[] result = new int[key];
        for (int index = 0; index < key; index++) {
            result[index] = array.get(index)[1];
        }
        return result;
    }
}
