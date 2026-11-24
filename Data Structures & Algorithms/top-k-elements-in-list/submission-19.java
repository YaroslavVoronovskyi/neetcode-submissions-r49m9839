class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<Integer>[] list = new ArrayList[numbers.length + 1];
        for (int index = 0; index < list.length; index++) {
            list[index] = new ArrayList<>();
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[key];
        int index = 0;
        for (int i = list.length - 1; i > 0 && index < key; i--) {
            for (int number : list[i]) {
                result[index++] = number;
                if (index == key) {
                    return result;
                }
            }
        }
        return result;
    }
}
