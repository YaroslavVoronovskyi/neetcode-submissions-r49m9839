class Solution {
    public int reverse(int number) {
        if (number == Integer.MIN_VALUE) {
            return 0;
        }
        int org = number;
        number = Math.abs(number);
        long result = Long.parseLong(new StringBuilder(String.valueOf(number)).reverse().toString());
        if (org < 0) {
            result *= -1;
        }
        if (result < -(1 << 31) || result > (1 << 31) - 1) {
            return 0;
        }
        return (int) result;
    }
}
