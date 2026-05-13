class Solution {
     public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(interval[0], max);
        }

        int[] mp = new int[max + 1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            mp[start] = Math.max(end + 1, mp[start]);
        }

        int right = 0;
        int have = -1;
        int intervalStart = -1;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) intervalStart = i;
                have = Math.max(mp[i] - 1, have);
            }
            if (have == i) {
                intervals[right++] = new int[]{intervalStart, have};
                have = -1;
                intervalStart = -1;
            }
        }

        if (intervalStart != -1) {
            intervals[right++] = new int[]{intervalStart, have};
        }
        if (intervals.length == right) {
            return intervals;
        }

        int[][] result = new int[right][];
        System.arraycopy(intervals, 0, result, 0, right);

        return result;
    }
}
