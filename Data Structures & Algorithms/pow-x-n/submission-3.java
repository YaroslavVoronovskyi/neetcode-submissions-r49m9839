class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = x;
        for (int index = 1; index < Math.abs(n); index++) {
            result *= x;
        }
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }
}
