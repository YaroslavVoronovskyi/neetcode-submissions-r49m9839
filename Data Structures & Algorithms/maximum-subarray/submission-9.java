class Solution {
    public int maxSubArray(int[] numbers) {
        int result = numbers[0];
        int current = 0;
        for (int number : numbers) {
            if (current < 0) {
                current = 0;
            }
            current += number;
            result = Math.max(current, result);
        }
        return result;
    }
}
