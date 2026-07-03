class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long) middle * middle > x) {
                right = middle - 1;
            } else if ((long) middle * middle < x) {
                left = middle + 1;
                result = middle;
            } else {
                return middle;
            }
        }
        return result;
    }
}