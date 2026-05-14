class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int size = intervals.length;
        int[] array = new int[size];
        array[0] = 1;

        for (int i = 1; i < size; i++) {
            int idx = binarySearch(i, intervals[i][0], intervals);
            if (idx == 0) {
                array[i] = array[i - 1];
            } else {
                array[i] = Math.max(array[i - 1], 1 + array[idx - 1]);
            }
        }

        return size - array[size - 1];
    }

    private int binarySearch(int right, int target, int[][] intervals) {
        int left = 0;
        while ( left < right) {
            int middle = (left + right) >> 1;
            if (intervals[middle][1] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
