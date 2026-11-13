class Solution {
    public int findTargetSumWays(int[] numbers, int target) {
        int size = numbers.length;
        Map<Integer, Integer>[] cache = new HashMap[size + 1];
        for (int index = 0; index <= size; index++) {
            cache[index] = new HashMap<>();
        }
        cache[0].put(0, 1);

        for (int index = 0; index < size; index++) {
            for (Map.Entry<Integer, Integer> entry : cache[index].entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                cache[index + 1].put(total + numbers[index], cache[index + 1].getOrDefault(total + numbers[index], 0) + count);
                cache[index + 1].put(total - numbers[index], cache[index + 1].getOrDefault(total - numbers[index], 0) + count);
            }
        }
        return cache[size].getOrDefault(target, 0);
    }
}
