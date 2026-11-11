class Solution {
    public int lengthOfLIS(int[] numbers) {
        int size = numbers.length;
        List<Integer> cache = new ArrayList<>();
        cache.add(numbers[0]);
        int count = 1;
        for (int index = 1; index < size; index++) {
            if (cache.get(cache.size() - 1) < numbers[index]) {
                cache.add(numbers[index]);
                count++;
                continue;
            }
            int result = Collections.binarySearch(cache, numbers[index]);
            if (result < 0) {
                result = -result - 1;
                cache.set(result, numbers[index]);
            }
        }
        return count;
    }
}
