class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getValue(), entry.getKey()});
        }
        list.sort((a, b) -> b[0] - a[0]);
        int[] result = new int[key];
        for (int index = 0; index < key; index++) {
            result[index] = list.get(index)[1];
        }
        return result;
    }
}
