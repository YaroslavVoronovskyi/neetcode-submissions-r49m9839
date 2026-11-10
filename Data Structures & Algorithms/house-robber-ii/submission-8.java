class Solution {
    public int rob(int[] numbers) {
        return Math.max(numbers[0], Math.max(
            helper(Arrays.copyOfRange(numbers, 1, numbers.length)),
            helper(Arrays.copyOfRange(numbers, 0, numbers.length - 1))));
    }

    private int helper(int[] numbers) {
        int rob1 = 0;
        int rob2 = 0;

        for (int number : numbers) {
            int temp = Math.max(rob1 + number, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
