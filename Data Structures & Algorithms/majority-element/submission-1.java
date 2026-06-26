class Solution {
    public int majorityElement(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        int maxCount = 0;
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
            if (count.get(number) > maxCount) {
                result = number;
                maxCount = count.get(number);
            }
        }
        return result;
    }
}