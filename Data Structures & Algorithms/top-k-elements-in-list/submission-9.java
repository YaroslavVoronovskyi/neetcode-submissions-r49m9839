class Solution {
    public int[] topKFrequent(int[] numbers, int key) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        
        List<Integer>[] freq = new List[numbers.length + 1];
        for (int index = 0; index < freq.length; index++) {
            freq[index] = new ArrayList<>();

        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        
        int[] array = new int[key];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < key; i--) {
            for (int number : freq[i]) {
                array[index++] = number;
                if (index == key) {
                    return array;
                }
            }
        }
        return array;
    }
}
