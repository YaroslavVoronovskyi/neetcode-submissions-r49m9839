class Solution {
    public int[] productExceptSelf(int[] numbers) {
        int size = numbers.length;
        int[] result = new int[size];

        result[0] = 1;
        for (int i = 1; i < size; i++) {
            result[i] = result[i - 1] * numbers[i - 1];
        }
        int postfix = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= numbers[i];
        }
        return result;
    }
}  
