class Solution {
    public boolean isHappy(int number) {
        int slow = number;
        int fast = sumOfSquares(number);
        while (slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }
        return fast == 1;
    }

    private int sumOfSquares(int number) {
        int output = 0;
        while (number > 0) {
            output += (number % 10) * (number % 10);
            number /= 10;
        }
        return output;
    }
}
