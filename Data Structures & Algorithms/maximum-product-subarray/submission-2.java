class Solution {
    public int maxProduct(int[] numbers) {
        int result = numbers[0];
        int size = numbers.length;
        int prefix = 0;
        int suffix = 0;
        for (int index = 0; index < size; index++) {
            prefix = numbers[index] * (prefix == 0 ? 1 : prefix);
            suffix = numbers[size - 1 - index] * (suffix == 0 ? 1 : suffix);
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
    }
}
