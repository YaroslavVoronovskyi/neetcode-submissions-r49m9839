class Solution {
    public int mySqrt(int x) {
        if ( x == 0) {
            return 0;
        }
        int result = 1;
        for (int index = 1; index <= x; index++) {
            if ((long) index * index > x) {
                return result;
            }
            result = index;
        }
        return result;
    }
}