class Solution {
    public int findTargetSumWays(int[] numbers, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);

        for (int number : numbers) {
            Map<Integer, Integer> nextCache = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                nextCache.put(total + number, nextCache.getOrDefault(total + number, 0) + count);
                nextCache.put(total - number, nextCache.getOrDefault(total - number, 0) + count);
            }
            cache = nextCache;
        }
        return cache.getOrDefault(target, 0);
    }
}
