class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int inf = Integer.MAX_VALUE;
        List<int[]>[] adjacency = new ArrayList[n];
        int[][] distances = new int[n][k + 5];
        for (int index = 0; index < n; index++) {
            Arrays.fill(distances[index], inf);
        }

        for (int index = 0; index < n; index++) {
            adjacency[index] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adjacency[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        distances[src][0] = 0;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int cost = top[0];
            int node = top[1];
            int stops = top[2];
            if (node == dst) {
                return cost;
            }
            if (stops == k || distances[node][stops + 1] < cost) {
                continue;
            }
            for (int[] neighbor : adjacency[node]) {
                int nei = neighbor[0];
                int w = neighbor[1];
                int nextCost = cost + w;
                int nextStops = stops + 1;
                if (distances[nei][nextStops + 1] > nextCost) {
                    distances[nei][nextStops + 1] = nextCost;
                    minHeap.offer(new int[]{nextCost, nei, nextStops});
                }
            }
        }
        return -1;
    }
}
