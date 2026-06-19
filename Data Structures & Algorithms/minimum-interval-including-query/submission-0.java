class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            int current = -1;
            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (left <= query && query <= right) {
                    if (current == -1 || (right - left + 1) < current) {
                        current = right - left + 1;
                    }
                }
            }
            result[index++] = current;
        }
        return result;
    }
}
