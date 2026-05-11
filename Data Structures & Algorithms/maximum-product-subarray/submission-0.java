class Solution {
    public int maxProduct(int[] numbers) {
        int result = numbers[0];
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            int current = numbers[i];
            result = Math.max(result, current);
            for (int j = i + 1; j < size; j++) {
                current *= numbers[j];
                result = Math.max(result, current);
            }
        }
        return result;
    }
}
