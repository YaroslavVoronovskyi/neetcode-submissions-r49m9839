class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int[] trip : trips) {
            left = Math.min(left, trip[1]);
            right = Math.max(right, trip[2]);
        }
        int number = right - left + 1;
        int[] passChange = new int[number + 1];
        for (int[] trip : trips) {
            passChange[trip[1] - left] += trip[0];
            passChange[trip[2] - left] -= trip[0];
        }
        int curPass = 0;
        for (int change : passChange) {
            curPass += change;
            if (curPass > capacity) {
                return false;
            }
        }
        return true;
    }
}