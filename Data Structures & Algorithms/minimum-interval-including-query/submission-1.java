class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<int[]> events = new ArrayList<>();
        for (int index = 0; index < intervals.length; index++) {
            events.add(new int[]{intervals[index][0], 0, intervals[index][1] - intervals[index][0] + 1, index});
            events.add(new int[]{intervals[index][1], 2, intervals[index][1] - intervals[index][0] + 1, index});
        }
        for (int index = 0; index < queries.length; index++) {
            events.add(new int[]{queries[index], 1, index});
        }
        events.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] inactive = new boolean[intervals.length];
        for (int[] event : events) {
            if (event[1] == 0) {
                queue.offer(new int[]{event[2], event[3]});
            } else if (event[1] == 2) {
                inactive[event[3]] = true;
            } else {
                while (!queue.isEmpty() && inactive[queue.peek()[1]]) {
                    queue.poll();
                }
                if (!queue.isEmpty()) {
                    result[event[2]] = queue.peek()[0];
                }
            }
        }
        return result;
    }
}
