class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        if (size == 0) {
            return new int[]{1};
        }
        if (digits[size - 1] < 9) {
            digits[size - 1] += 1;
            return digits;
        } else {
            int[] newDigits = new int[size - 1];
            System.arraycopy(digits, 0, newDigits, 0, size - 1);
            int[] result = plusOne(newDigits);
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = 0;
            return result;
        }
    }
}
