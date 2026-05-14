class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int size = intervals.length;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = 1;
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    array[i] = Math.max(array[i], 1 + array[j]);
                }
            }
        }
        int maxNonOverlapping = Arrays.stream(array).max().getAsInt();
        return size - maxNonOverlapping;
    }
}
