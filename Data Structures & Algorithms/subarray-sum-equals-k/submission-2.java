class Solution {
    public int subarraySum(int[] numbers, int key) {
        int result = 0;
        int currentSum = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int number : numbers) {
            currentSum += number;
            int diff = currentSum - key;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}