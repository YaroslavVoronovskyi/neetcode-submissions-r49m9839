class Solution {
    public int reverse(int number) {
        final int MIN = -2147483648;
        final int MAX = 2147483647;
        int result = 0;
        while (number != 0) {
            int digit = number % 10;
            number /= 10;
            if (result > MAX / 10 || (result == MAX / 10 && digit > MAX % 10)) {
                return 0;
            }
            if (result < MIN / 10 || (result == MIN / 10 && digit < MIN % 10)) {
                return 0;
            }
            result = (result * 10) + digit;
        }
        return result;
    }
}
