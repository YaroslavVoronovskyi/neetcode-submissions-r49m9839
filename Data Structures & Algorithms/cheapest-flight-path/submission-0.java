class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int inf = Integer.MAX_VALUE;
        List<int[]>[] list = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int index = 0; index < n; index++) {
            Arrays.fill(dist[index], inf);
        }
        for (int index = 0; index < n; index++) {
            list[index] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            list[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        dist[src][0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, src, -1});

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int cst = top[0];
            int node = top[1];
            int stops = top[2];
            if (node == dst) {
                return cst;
            }
            if (stops == k || dist[node][stops + 1] < cst) {
                continue;
            }
            for (int[] item : list[node]) {
                int nei = item[0];
                int w = item[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    queue.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;
    }
}
