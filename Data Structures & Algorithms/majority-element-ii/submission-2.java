class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        Map<Integer, Integer> count  = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int key : count.keySet()) {
            if (count.get(key) > numbers.length / 3) {
                result.add(key);
            }
        }
        return result;
    }
}