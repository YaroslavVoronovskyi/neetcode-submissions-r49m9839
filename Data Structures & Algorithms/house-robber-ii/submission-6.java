class Solution {
    public int rob(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        return Math.max(helper(Arrays.copyOfRange(numbers, 1, numbers.length)),
                        helper(Arrays.copyOfRange(numbers, 0, numbers.length - 1)));
    }

    private int helper(int[] numbers) {
        int size = numbers.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return numbers[0];
        }
        int[] cache = new int[size];
        cache[0] = numbers[0];
        cache[1] = Math.max(numbers[0], numbers[1]);

        for (int index = 2; index < size; index++) {
            cache[index] = Math.max(cache[index - 1], numbers[index] + cache[index - 2]);
        }
        return cache[size - 1];
    }
}
