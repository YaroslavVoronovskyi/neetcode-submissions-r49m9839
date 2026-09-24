class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int index = 1; index <= n; index++) {
            adj.put(index, new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(k, 0);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int time = current[1];
            if (dist.get(node) < time) {
                continue;
            }
            for (int[] item : adj.get(node)) {
                int nextNode = item[0];
                int weight = item[1];
                if (time + weight < dist.get(nextNode)) {
                    dist.put(nextNode, time + weight);
                    queue.offer(new int[]{nextNode, time + weight});
                }
            }
        }
        int result = Collections.max(dist.values());
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
