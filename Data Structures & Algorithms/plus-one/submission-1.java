class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        int size = digits.length;
        for (int index = size - 1; index >= 0; index--) {
            if (carry) {
                if (digits[index] == 9) {
                    digits[index] = 0;
                } else {
                    digits[index]++;
                    carry = false;
                }
            }
        }
        if (carry) {
            int[] result = new int[size + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, size);
            return result;
        }
        return digits;
    }
}
