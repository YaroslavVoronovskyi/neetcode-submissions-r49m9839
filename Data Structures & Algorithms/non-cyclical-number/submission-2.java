class Solution {
    public boolean isHappy(int number) {
        int slow = number;
        int fast = sumOfSquares(number);
        int power = 1;
        int lam = 1;
        
        while (slow != fast) {
            if (power == lam) {
                slow = fast;
                power *= 2;
                lam = 0;
            }
            lam++;
            fast = sumOfSquares(fast);
        }
        return fast == 1;
    }

    private int sumOfSquares(int number) {
        int output = 0;
        while (number > 0) {
            int digit = number % 10;
            digit = digit * digit;
            output += digit;
            number /= 10;
        }
        return output;
    }
}
