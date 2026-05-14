class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals.length - depthFirstSearch(intervals, 0, -1);
    }

    private int depthFirstSearch(int[][] intervals, int index, int previous) {
        if (index == intervals.length) {
            return 0;
        }
        int result = depthFirstSearch(intervals, index + 1, previous);
        if (previous == -1 || intervals[previous][1] <= intervals[index][0]) {
            result = Math.max(result, 1 + depthFirstSearch(intervals, index + 1, index));
        }
        return result;
    }
}
