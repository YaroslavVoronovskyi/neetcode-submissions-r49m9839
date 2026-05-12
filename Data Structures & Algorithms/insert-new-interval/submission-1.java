class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;
        if (size == 0) {
            return new int[][]{ newInterval };
        }
        int target = newInterval[0];
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (intervals[middle][0] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int index = 0; index < left; index++) {
            result.add(intervals[index]);
        }
        result.add(newInterval);
        for (int index = left; index < size; index++) {
            result.add(intervals[index]);
        }

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : result) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
