class Solution {

    private int[] memo;

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int size = intervals.length;
        memo = new int[size];
        Arrays.fill(memo, -1);

        int maxNonOverlapping = depthFirstSearch(intervals, 0);
        return size - maxNonOverlapping;
    }

    private int depthFirstSearch(int[][] intervals, int i) {
        if (i >= intervals.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int result = 1;
        for (int j = i + 1; j < intervals.length; j++) {
            if (intervals[i][1] <= intervals[j][0]) {
                result = Math.max(result, 1 + depthFirstSearch(intervals, j));
            }
        }
        memo[i] = result;
        return result;
    }
}
