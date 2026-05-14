class Solution {
    public int reverse(int number) {
        long result = recursion(Math.abs(number), 0) * (number < 0 ? -1 : 1);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    private long recursion(int number, long reverse) {
        if (number == 0) {
            return reverse;
        }
        reverse = reverse * 10 + number % 10;
        return recursion(number / 10, reverse);
    }
}
