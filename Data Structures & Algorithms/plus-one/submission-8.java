class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        for (int index = size - 1; index >= 0; index--) {
            if (digits[index] < 9) {
                digits[index]++;
                return digits;
            }
            digits[index] = 0;
        }
        int[] result = new int[size + 1];
        result[0] = 1;
        return result;
    }
}
