class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
            if (count.size() > 2) {
                Map<Integer, Integer> newCount = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    if (entry.getValue() > 1) {
                        newCount.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
                count = newCount;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int key : count.keySet()) {
            int frequency = 0;
            for (int number : numbers) {
                if (number == key) {
                    frequency++;
                }
            }
            if (frequency > numbers.length / 3) {
                result.add(key);
            }
        }
        return result;
    }
}