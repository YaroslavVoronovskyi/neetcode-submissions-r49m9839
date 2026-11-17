class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < digits.length; index++) {
            builder.append(digits[index]);
        }
        long number = Long.parseLong(builder.toString()) + 1;
        String expression = String.valueOf(number);
        int[] result = new int[expression.length()];
        for (int index = 0; index < result.length; index++) {
            result[index] = Integer.parseInt(expression.substring(index, index + 1));
        }
        return result;
    }
}
