class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> result = new HashMap<>();
        int index = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (index < intervals.length && intervals[index][0] <= q) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                queue.offer(new int[]{right - left + 1, right});
                index++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < q) {
                queue.poll();
            }
            result.put(q, queue.isEmpty() ? -1 : queue.peek()[0]);
        }
        int[] array = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            array[j] = result.get(queries[j]);
        }
        return array;
    }
}
