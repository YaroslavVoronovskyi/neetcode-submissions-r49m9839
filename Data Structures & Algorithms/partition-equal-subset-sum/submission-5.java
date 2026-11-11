class Solution {
    public boolean canPartition(int[] numbers) {
        if (Arrays.stream(numbers).sum() % 2 != 0) {
            return false;
        }

        Set<Integer> cache = new HashSet<>();
        cache.add(0);
        int target = Arrays.stream(numbers).sum() / 2;

        for (int index = numbers.length - 1; index >= 0; index--) {
            Set<Integer> nextCache = new HashSet<>();
            for (int number : cache) {
                if (number + numbers[index] == target) {
                    return true;
                }
                nextCache.add(number + numbers[index]);
                nextCache.add(number);
            }
            cache = nextCache;
        }
        return false;
    }
}
