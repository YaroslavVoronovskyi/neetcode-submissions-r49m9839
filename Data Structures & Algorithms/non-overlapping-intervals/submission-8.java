class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int size = intervals.length;
        int result = 0;
        int previousEnd = intervals[0][1];

        for (int index = 1; index < size; index++) {
            int start = intervals[index][0];
            int end = intervals[index][1];
            if (start >= previousEnd) {
                previousEnd = end;
            } else {
                result++;
                previousEnd = Math.min(end, previousEnd);
            }
        }
        return result;
    }
}
