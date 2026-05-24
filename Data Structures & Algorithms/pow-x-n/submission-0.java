class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int index = 0; index < Math.abs(n); index++) {
            result *= x;
        }
        return n >= 0 ? result : 1 / result;
    }
}
