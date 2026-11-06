class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int query : Arrays.stream(queries).sorted().toArray()) {
            while (index < intervals.length && intervals[index][0] <= query) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                minHeap.offer(new int[]{right - left + 1, right});
                index++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            map.put(query, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int item = 0; item < queries.length; item++) {
            result[item] = map.get(queries[item]);
        }
        return result;
    }
}
