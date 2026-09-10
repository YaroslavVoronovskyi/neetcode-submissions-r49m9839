class Solution {
    public int integerBreak(int number) {
        if (number <= 3) {
            return number - 1;
        }
        int result = 1;
        while (number > 4) {
            result *= 3;
            number -= 3;
        }
        return result * number;
    }
}