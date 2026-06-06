class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], 
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int time = current[1];
            if (visited.contains(time)) {
                continue;
            }
            visited.add(time);
            t = node;
            if (map.containsKey(time)) {
                for (int[] next : map.get(time)) {
                    int n2 = next[0];
                    int w2 = next[1];
                    if (!visited.contains(n2)) {
                        queue.offer(new int[]{node + w2, n2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
