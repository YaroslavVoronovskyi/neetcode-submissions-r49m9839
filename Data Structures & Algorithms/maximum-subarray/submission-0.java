class Solution {
    public int maxSubArray(int[] numbers) {
        int size = numbers.length;
        int result = numbers[0];
        for (int i = 0; i < size; i++) {
            int current = 0;
            for (int j = i; j < size; j++) {
                current += numbers[j];
                result = Math.max(result, current);
            }
        }
        return result;
    }
}
