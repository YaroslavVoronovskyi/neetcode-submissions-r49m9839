class Solution {
    public int integerBreak(int number) {
        if (number <= 3) {
            return number - 1;
        }
        int result = (int) Math.pow(3, number / 3);
        if (number % 3 == 1) {
            return (result / 3) * 4;
        }
        return result * Math.max(1, number % 3);
    }
}