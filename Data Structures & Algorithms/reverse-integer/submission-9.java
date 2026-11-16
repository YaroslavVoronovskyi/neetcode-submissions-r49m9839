class Solution {
    public int reverse(int number) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int result = 0;

        while (number != 0) {
            int digit = number % 10;
            number /= 10;
            if (result > max / 10 || (result == max / 10 && digit > max % 10)) {
                return 0;
            }
            if (result < min / 10 || (result == min / 10 && digit < min % 10)) {
                return 0;
            }
            result = (result * 10) + digit;
        }
        return result;
    }
}
